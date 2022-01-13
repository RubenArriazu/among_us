package ud3.practica3.e3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int PORT = 5656;
	private static final int NUMBER_OF_CLIENTS = 3;
	public static void main(String[] args) {
		try {
			
			ServerSocket server = new ServerSocket(PORT);
			
			for (int i = 0; i < NUMBER_OF_CLIENTS; i++) {
				Socket client = server.accept();

				OutputStream outputStream = client.getOutputStream();
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
				dataOutputStream.writeUTF("Bienvenido cliente " + i);
				
				dataOutputStream.close();
				outputStream.close();
				client.close();
			}

			server.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
