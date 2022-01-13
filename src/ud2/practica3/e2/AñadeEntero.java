package ud2.practica3.e2;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class AñadeEntero extends Thread {
	
	private ArrayList<Integer> lista;
	private Semaphore semaphore;
	private Integer elemento;;

	public AñadeEntero(ArrayList<Integer> lista, Integer elemento, Semaphore semaphore) {
		this.lista = lista;
		this.semaphore = semaphore;
		this.elemento = elemento;
	}

	@Override
	public void run() {
		super.run();
		try {
			semaphore.acquire();
			lista.add(elemento);
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
