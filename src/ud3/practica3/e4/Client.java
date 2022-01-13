package ud3.practica3.e4;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static final String ADDRESS = "localhost";
	private static final int PORT = 5656;

	public static void main(String[] args) {
		try {
			
			Socket cliente = new Socket(ADDRESS, PORT);

			InputStream inputStream = cliente.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			String response = dataInputStream.readUTF();
			System.out.println(response);
			dataInputStream.close();
			inputStream.close();

			cliente.close();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
