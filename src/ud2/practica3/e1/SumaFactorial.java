package ud2.practica3.e1;

import java.util.concurrent.Semaphore;

public class SumaFactorial extends Thread {
	private Entero numero;
	private Integer x;
	private Semaphore semaphore;

	public SumaFactorial(Semaphore semaphore, Entero numero, Integer x) {
		this.numero = numero;
		this.x = x;
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		super.run();
		Integer resultadoFactorial = factorial(x);
		try {
			semaphore.acquire();
			numero.setValue(numero.getValue() + resultadoFactorial);
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
