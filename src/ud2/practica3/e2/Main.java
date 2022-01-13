package ud2.practica3.e2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		Semaphore semaphore = new Semaphore(1);
		ArrayList<AñadeEntero> hilos = new ArrayList<AñadeEntero>();
		
		for (int i = 0; i <= 10; i++) {
			AñadeEntero añadeEntero = new AñadeEntero(lista, i, semaphore);
			añadeEntero.start();
			hilos.add(añadeEntero);
		}

		for (AñadeEntero hilo : hilos) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(lista);

	}
}
