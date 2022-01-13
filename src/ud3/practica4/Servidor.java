package ud3.practica4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	
	private static final int PUERTO = 5050;
	private static InetAddress direccionCliente;
	private static int puertoCliente;
	
	public static void main(String[] args) {
		try {
			
			// Recibe cadenas de texto del cliente
			String cadena = recibeTexto();

			// Transforma la cadena en mayusculas
			cadena = cadena.toUpperCase();

			// Envia la nueva cadena en mayusculas al cliente
			enviaTexto(cadena);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String recibeTexto() throws IOException {
		DatagramSocket socket = new DatagramSocket(PUERTO);
		byte[] buffer = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

		// Guarda la dirrecion y el puerto del cliente
		direccionCliente = datagramPacket.getAddress();
		puertoCliente = datagramPacket.getPort();
		
		socket.receive(datagramPacket);
		socket.close();
		return buffer.toString();
	}

	private static void enviaTexto(String txt) throws IOException {
		DatagramPacket paquete = new DatagramPacket(txt.getBytes(), txt.length(), direccionCliente, puertoCliente);
		DatagramSocket socket = new DatagramSocket(PUERTO);
		socket.send(paquete);
		socket.close();
	}

}
