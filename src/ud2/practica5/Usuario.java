package ud2.practica5;

import java.util.concurrent.Semaphore;

public class Usuario extends Thread {

	private Dato dato;

	// Este numero deberia de ser infinito
	private static int infinito = 1_000_000;

	private static Semaphore estadoEscritura = new Semaphore(1);
	private static Semaphore estadoLectura = new Semaphore(infinito);

	public Usuario(String nombreUsuario, Dato dato) {
		super(nombreUsuario);
		this.dato = dato;
	}

	// Un usuario aleatoriamente lee o escribe
	@Override
	public void run() {
		super.run();
		if (Math.random() > 0.5) {
			this.escribir();
			this.leer();
		} else {
			this.leer();
			this.escribir();
		}
	}


	// Varios usuario pueden leer el dato mientras
	// el dato no se este escribiendo.
	public void leer() {
		while (true) {
			if (estadoEscritura.availablePermits() == 1) {
				try {
					estadoLectura.acquire();
					System.out.println("Inicia LECTURA - Usuario: " + getName());
					System.out.println(System.nanoTime() + " [LECTURA] Usuario: " + getName() + " - Dato: " + dato.getDato());
					// sleep(1000);
					System.out.println("Termina LECTURA - Usuario: " + getName());
					estadoLectura.release();
					return;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	// Solo un usuario puede acceder al dato mientras se 
	// esta escribiendo.
	public synchronized void escribir() {
		while (true) {
			try {
				estadoEscritura.acquire();
				if (estadoLectura.availablePermits() == infinito) {
					System.out.println("Inicia ESCRITURA - Usuario: " + getName());
					int contador = dato.getDato() + 1;
					dato.setDato(contador);
					// sleep(1000);
					System.out.println(System.nanoTime() + " [ESCRITURA] Usuario: " + getName() + " - Dato: " + dato.getDato());
					System.out.println("Termina ESCRITURA - Usuario: " + getName());
					estadoEscritura.release();
					return;
				}
				estadoEscritura.release();
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
