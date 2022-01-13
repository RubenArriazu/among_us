package ud2.maths.e2_selfmade;

// Largest Number of Divisors
public class LND extends Thread {

	public static final int MAXIMUM_NUMBER = 100_000;

	public static int iteration = 0;
	public static int largestNumber = 0;

	@Override
	public void run() {
		super.run();

		int i;
		do {
			i = getIterationSafe();
			int numeroDivisores = MathsUtils.divCount(i);
			actualizaNumeroMaximo(numeroDivisores);
		} while (i < MAXIMUM_NUMBER);

	}

	private synchronized int getIterationSafe() {
		int i = iteration;
		iteration++;
		return i;
	}

	private synchronized void actualizaNumeroMaximo(int n) {
		if (n > largestNumber) {
			largestNumber = n;
		}
	}

}
