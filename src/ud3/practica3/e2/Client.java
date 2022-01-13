package ud3.practica3.e2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private static final int PORT = 5656;
	private static final String ADDRESS = "localhost";

	public static void main(String[] args) {
		
		try {
			
			// Crea un socket
			Socket cliente = new Socket(ADDRESS, PORT);

			// Envia al servidor un numero leido por la entrada estandar
			OutputStream outputStream = cliente.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			int numberStdin = readStdInput();
			dataOutputStream.writeInt(numberStdin);
			dataOutputStream.flush();
			// dataOutputStream.close();
			// outputStream.close();

			// Obtiene el cuadrado de ese numero del servidor
			InputStream inputStream = cliente.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			int result = dataInputStream.readInt();
			System.out.println(result);
			dataInputStream.close();
			inputStream.close();

			// Cierra el socket
			cliente.close();
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int readStdInput() {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();
		return number;
	}

}
