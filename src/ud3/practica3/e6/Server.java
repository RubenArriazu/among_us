package ud3.practica3.e6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	// Config
	private static final int PORT = 5656;

	// Sockets
	private static ServerSocket server;
	private static Socket client;

	// Streams
	private static InputStream inputStream;
	private static DataInputStream dataInputStream;
	private static OutputStream outputStream;
	private static DataOutputStream dataOutputStream;


	public static void main(String[] args) {
		setUp();
		countStrings();
		close();
	}
	
	// Start up the sockets and streams
	private static void setUp() {
		try {
			server = new ServerSocket(PORT);
			client = server.accept();
			inputStream = client.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			outputStream = client.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// The actual program
	private static void countStrings() {
		try {
			for (;;) {
				String input = dataInputStream.readUTF();
				if (input.equals("*")) {
					break;
				}
				dataOutputStream.writeUTF(String.valueOf(input.length()));
				dataOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	// Close every socket and stream in reverse order
	private static void close() {
		try {
			dataInputStream.close();
			inputStream.close();
			
			dataOutputStream.close();
			outputStream.close();

			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
