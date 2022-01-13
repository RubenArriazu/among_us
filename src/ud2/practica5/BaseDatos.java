package ud2.practica5;

public class BaseDatos extends Thread {

	private static Dato dato;

	public static void main(String[] args) {
		
		dato = new Dato();
		Usuario[] usuarios = new Usuario[100_000];
		
		for (int i = 0; i < usuarios.length; i++) {
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
