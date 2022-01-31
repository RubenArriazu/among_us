package ud3.hack_streams;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyServer {

	private static final int PORT = 5050;

	public static void main(String[] args) {
		try {

			ServerSocket server = new ServerSocket(PORT);
			Socket client = server.accept();
			InputStream inputStream = client.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			System.out.println(dataInputStream.readUTF());
			dataInputStream.close();
			inputStream.close();
			client.close();
			server.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
