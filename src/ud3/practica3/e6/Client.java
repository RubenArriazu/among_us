package ud3.practica3.e6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	// Configuration
	private static final int PORT = 5656;
	private static final String ADDRESS = "localhost";

	// Socket and streams
	private static Socket client;
	private static InputStream inputStream;
	private static DataInputStream dataInputStream;
	private static OutputStream outputStream;
	private static DataOutputStream dataOutputStream;


	public static void main(String[] args) {
		setUp();
		sendStringsToServer();
		close();
	}

	// The actual solution
	private static void sendStringsToServer() {
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			String userInput = scanner.next();
			
			try {
				
				dataOutputStream.writeUTF(userInput);
				dataOutputStream.flush();
				
				if (userInput.equals("*")) {
					scanner.close();
					break;
				}
				
				String response = dataInputStream.readUTF();
				System.out.println(response);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}


	// Connect to the server and open streams
	private static void setUp() {
		try {
			
			client = new Socket(ADDRESS, PORT);
			
			inputStream = client.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			outputStream = client.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Close the sockets and server
	private static void close() {
		try {
			
			dataInputStream.close();
			inputStream.close();
			dataOutputStream.close();
			outputStream.close();
			client.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
