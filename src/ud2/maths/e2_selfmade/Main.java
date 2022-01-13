package ud2.maths.e2_selfmade;

public class Main {

	private static int MACHINE_PROCESSORS = Runtime.getRuntime().availableProcessors();
	
	public static void main(String[] args) {

		LND[] hilos = new LND[MACHINE_PROCESSORS];
		
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new LND();
			hilos[i].start();
		}
		
		for (LND hilo : hilos) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(LND.largestNumber);
	
	}

}
