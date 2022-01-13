package ud3.practica3.e4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {

	private static final int PORT = 5656;

	public static void main(String[] args) {
		try {
			
			ServerSocket server = new ServerSocket(PORT);
			
			for (int i = 1;; i++) {
				Socket clientSocket = server.accept();
				ServeClient client = new ServeClient(clientSocket, i);
				client.start();
				System.out.println("[" + LocalDateTime.now().toString() + "] " + clientSocket.getInetAddress());
				
				// try {
				// 	Thread.sleep(4000);
				// } catch (InterruptedException e) {
				// 	e.printStackTrace();
				// }
			}

			// server.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
