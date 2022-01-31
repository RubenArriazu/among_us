package ud3.practica5;

public class ServidorMulticast {

	private static final String DIRECCION = "237.0.0.1";
	private static final int PUERTO = 300;
	private static final String MENSAJE = "Hola mundo";
	
	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4", "true");
	}
	
	private static void enviaMensaje() {

	}

}
