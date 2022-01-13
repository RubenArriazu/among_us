package ud2.practica3.e1;

import java.util.concurrent.Semaphore;

public class Main {

	private static Semaphore semaphore = new Semaphore(1);
	private static int n = 11;

	public static void main(String[] args) {

		// Realiza la suma
		// Cada factor de la suma se realiza en un hilo
		Entero numero = new Entero();
		numero.setValue(0);
		Thread[] hilos = new Thread[n];
		for (int i = 0; i < n; i++) {
			hilos[i] = new SumaFactorial(semaphore, numero, i);
			hilos[i].start();
		}

		// Espera a ejecucion de todos los hilos
		for (Thread hilo : hilos) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Mustra el resultado
		System.out.println("\nResultado ==> " + numero.getValue());

	}
}
