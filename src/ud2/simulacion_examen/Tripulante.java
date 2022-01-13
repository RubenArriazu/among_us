package ud2.simulacion_examen;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Tripulante extends Thread {
	
	private static volatile Prueba[] pruebas = {
		new Prueba("Reparar cables", 100, 300, 2),
		new Prueba("Pasar tarjeta de seguridad", 50, 400, 1),
		new Prueba("Destruir asteroides", 300, 500, 3),
		new Prueba("Expulsar basura", 75, 150, 2)
	};

	public static int numeroTripulantesTerminado;

	private ArrayList<Prueba> pruebasPorCompletar = new ArrayList<Prueba>();

	public Tripulante(int codigoTripulante) {
		super("Tripulante_" + String.valueOf(codigoTripulante));
		for (Prueba prueba : pruebas) {
			pruebasPorCompletar.add(prueba);
		}
		System.out.println(getName() + " ha entrado en el lobby");
	}

	@Override
	public void run() {
		super.run();
		while (pruebasPorCompletar.size() != 0) {
			realizaPrueba();
		}
		terminaPruebas();
	}

	private void realizaPrueba() {
		Prueba prueba = pruebaPendiente();
		int duracion = prueba.duracionPrueba();
		Semaphore semaphore = prueba.getTripulantesSimultaneos();
		try {
			semaphore.acquire();
			System.out.println(getName() + " ha comenzado \"" + prueba.getNombre() + "\"");
			sleep(duracion);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " ha terminado \"" + prueba.getNombre() + "\"");
		semaphore.release();
		pruebasPorCompletar.remove(prueba);
		
		int Q = pruebas.length;
		int P = Q - pruebasPorCompletar.size();
		System.out.println(getName() + ">Pruebas completadas (" + P + "/" + Q + ")");
	}
	
	private Prueba pruebaPendiente() {
		int aleatorio = new Random().nextInt(pruebasPorCompletar.size());
		return pruebasPorCompletar.get(aleatorio);
	}
	
	private void terminaPruebas() {
		synchronized (Tripulante.class) {
			numeroTripulantesTerminado++;
		}
		System.out.println("\nTODAS LAS PRUEBAS TERMINADAS---------- " + getName() + "\n");
	}

}
