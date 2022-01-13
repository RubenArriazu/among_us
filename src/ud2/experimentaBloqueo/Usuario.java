package ud2.experimentaBloqueo;

public class Usuario extends Thread {

	private Dato dato;
	private static boolean primeraIteracion = true;

	public Usuario(String nombreUsuario, Dato dato) {
		super(nombreUsuario);
		this.dato = dato;
	}

	// Un usuario aleatoriamente lee o escribe
	@Override
	public void run() {
		super.run();
		if (primeraIteracion) {
			primeraIteracion = false;
			this.escribir();
		} else {
			this.leer();
		}
	}


	// Varios usuario pueden leer el dato mientras
	// el dato no se este escribiendo.
	public void leer() {
		System.out.println(System.nanoTime() + " [LECTURA] Usuario: " + getName() + " - Dato: " + dato.getDato());
	}


	// Solo un usuario puede acceder al dato mientras se 
	// esta escribiendo.
	public synchronized void escribir() {
			
			int contador = dato.getDato() + 1;
			dato.setDato(contador);
			System.out.println(System.nanoTime() + " [ESCRITURA] Usuario: " + getName() + " - Dato: " + dato.getDato());
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}

}
