package ud3.practica3.e1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

	private static String adress = "localhost";
	private static int port = 5656;

	public static void main(String[] args) {
		try {
			
			// Crea un socket
			Socket socket = new Socket(adress, port);
			
			// Envia mensaje al servidor
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			dos.writeUTF(args[0]);
			
			dos.close();
			os.close();

			// Cierra el socket
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
