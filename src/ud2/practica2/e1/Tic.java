package ud2.practica2.e1;

public class Tic extends Thread {
	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				sleep(500);
				System.out.println("TIC");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}
