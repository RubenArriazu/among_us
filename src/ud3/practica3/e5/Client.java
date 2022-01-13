package ud3.practica3.e5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	// Configuration variables
	private static final int PORT = 5656;
	private static final String ADDRESS = "localhost";

	// Sockets and streams
	private static Socket client;
	private static InputStream inputStream;
	private static DataInputStream dataInputStream;
	private static OutputStream outputStream;
	private static DataOutputStream dataOutputStream;


	public static void main(String[] args) {
		setUp();
		playGuessingGame();
		close();
	}


	// Set up the client socket and their streams
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


	// Guess the unknow number between 0 and 10
	private static void playGuessingGame() {
		Scanner scanner = new Scanner(System.in);
		
		for (;;) {
			// Ask for a number
			System.out.print("Introduce un número (entre el 0 y el 10): ");
			int number = scanner.nextInt();

			try {
				// Send the number to the server
				dataOutputStream.writeInt(number);
				dataOutputStream.flush();

				// Get the server response
				String response = dataInputStream.readUTF();
				System.out.println(response);

				// Check if the client has guess the number
				if (response.contains("Enhorabuena")) {
					scanner.close();
					break;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	// Close all opened resources in reverse order
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
