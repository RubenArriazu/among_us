package ud3.practica3.e1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static String adress = "localhost";
	private static int port = 5656;
	
	public static void main(String[] args) {
		
		try {
			
			// Crea un servidor
			ServerSocket server = new ServerSocket(port);
			
			// Espera a que se conecte un cliente
			Socket cliente = server.accept();
			InputStream is = cliente.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF().toUpperCase());
			dis.close();
			is.close();
			cliente.close();
			
			// Cierra el sevidor
			server.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
