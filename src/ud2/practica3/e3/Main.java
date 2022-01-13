package ud2.practica3.e3;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		int tenedores = 5;
		int numeroFilosofos = 5;
		Semaphore semaphore = new Semaphore(tenedores);
		Filosofo[] filosofos = new Filosofo[numeroFilosofos];

		// Crea y ejecuta los filosofos
		for (int i = 0; i < numeroFilosofos; i++) {
			var filosofo = new Filosofo(semaphore);
			filosofo.run();
			filosofos[i] = filosofo;
		}

		// Espera a que terminen
		for (var filosofo : filosofos) {
			filosofo.start();
		}
	}
}
