package ud2.practica1;

public class HiloFibonacci extends Thread {

	private int N;

	HiloFibonacci(int numero) {
		this.N = numero;
	}
	
	@Override
	public void run() {
		super.run();
		int a = 0, b = 1;
		System.out.print(a + " ");
		for (int i = 0; i < N; i++) {
			int c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}

}
