package ud2.practica3.e4;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		int numeroTenedores = 5;
		int numeroFilosofos = 5;
		Semaphore[] tenedores = new Semaphore[numeroTenedores];

		for (int i = 0; i < tenedores.length; i++) {
			tenedores[i] = new Semaphore(1, true);
		}
		
		for (int fil = 0; fil < numeroFilosofos; fil++) {
			int posicionTenedorA = fil;
			int posicionTenedorB;
			if (fil == numeroFilosofos - 1) {
				posicionTenedorB = 0;
			} else {
				posicionTenedorB = fil + 1;
			}
			new Filosofo(String.valueOf(fil), posicionTenedorA, posicionTenedorB, tenedores).start();
		}


	}
}
