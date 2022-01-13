package ud2.practica3.e3;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {
	private int comida = 100;
	private Semaphore semaphore;

	public Filosofo(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		super.run();
		while (comida > 0) {
			System.out.println("Pensando");
			try {
				semaphore.acquire(2);
				System.out.println("Comiendo");
				comida--;
				semaphore.release(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}
	}

}
