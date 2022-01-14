package ud3.practica4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	private static int PUERTO = 6000;
	private static int PUERTO_SERVIDOR = 5050;
	private static String DIRECCION_SERVIDOR = "127.0.0.1";

	public static void main(String[] args) {
		try {
			String mensaje = obtineMensaje();
			enviaMensaje(mensaje);
			String repuesta = respuestaServidor();
			System.out.println(repuesta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String obtineMensaje() {
		Scanner scanner = new Scanner(System.in);
		String mensaje = "";
		for (;;) {
			String cadena = scanner.next();
			if (cadena.equals("*")) {
				break;
			}
			mensaje += cadena;
		}
		scanner.close();
		return mensaje;
	}

	private static void enviaMensaje(String mensaje) {
		try {
			DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), mensaje.length(), InetAddress.getByName(DIRECCION_SERVIDOR), PUERTO_SERVIDOR);
			DatagramSocket socket = new DatagramSocket(PUERTO);
			socket.send(paquete);
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String respuestaServidor() throws IOException {
		DatagramSocket socket = new DatagramSocket(PUERTO);
		byte[] buffer = new byte[1024];
		DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
		socket.receive(paquete);
		socket.close();
		return new String(paquete.getData());
	}

}
