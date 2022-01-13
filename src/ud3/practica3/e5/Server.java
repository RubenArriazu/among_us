package ud3.practica3.e5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	// Port used by the program
	private static final int PORT = 5656;

	// Random number between 1 and 10
	private static final int RANDOM_NUMBER = (int) (Math.random() * 11);

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
		playGuessingGame();
		close();
	}

	// Start up the server, accept conections and create streams
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

	// Play the game
	private static void playGuessingGame() {
		try {

			// Iterate until the client guess the number
			for (int i = 1;; i++) {

				// Read the number from the client
				int guess;
				guess = dataInputStream.readInt();

				// End the loop in case the client has guessed the number
				if (guess == RANDOM_NUMBER) {
					dataOutputStream.writeUTF("Enhorabuena, has acertado");
					dataOutputStream.flush();
					break;
				}
				
				// Notify the client how many times has been wrong
				dataOutputStream.writeUTF("Numero equivocado, este es el intento número " + i);
				dataOutputStream.flush();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Close everything in reverse order
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
