package ud3.practica6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static final int PUERTO = 5656;

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			while (true) {
				Socket cliente = servidor.accept();
				new AtiendeCliente(cliente).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
