package ud2.practica6.semaforos;

import java.util.concurrent.Semaphore;

public class EquipoAtletismo {
	private Semaphore semaphore = new Semaphore(1);

	public void correrVuelta(int numeroAtleta) {
		try {
			semaphore.acquire();
			System.out.println("Atleta " + numeroAtleta + " | Corre Forrest corre");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void entregarTestigo(int numeroAtleta) {
		try {
			semaphore.acquire();
			System.out.println("Atleta " + numeroAtleta + " | Testigo entregado");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
