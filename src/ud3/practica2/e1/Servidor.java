package ud3.practica2.e1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {

		int puerto = 6000;
		ServerSocket server;
		
		try {
			
			while (true) {
				server = new ServerSocket(puerto);
				Socket cliente = server.accept();
				InputStream inputStream = cliente.getInputStream();
				DataInputStream dataInputStream = new DataInputStream(inputStream);

				String mensaje = dataInputStream.readUTF();

				if (mensaje.equals("Hola Don Pepito")) {
					System.out.println("Hola Don Jose");

				} else if (mensaje.equals("Adios Don Pepito")) {
					System.out.println("Adios Don Jose");
				} else {
					System.out.println("No nos conocemos");
				}

				server.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
