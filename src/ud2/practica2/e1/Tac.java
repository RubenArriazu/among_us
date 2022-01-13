package ud2.practica2.e1;

public class Tac extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			sleep(250);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				sleep(500);
				System.out.println("TAC");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

}
