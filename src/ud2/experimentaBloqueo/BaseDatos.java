package ud2.experimentaBloqueo;

public class BaseDatos extends Thread {

	private static Dato dato;

	public static void main(String[] args) {
		
		dato = new Dato();
		Usuario[] usuarios = new Usuario[20];
		
		for (int i = 0; i < usuarios.length; i++) {
			if (i == 1) {
				try {
					sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			usuarios[i] = new Usuario(String.valueOf(i), dato);
			usuarios[i].start();
		}

		for (Usuario usuario : usuarios) {
			try {
				usuario.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	
	}

}