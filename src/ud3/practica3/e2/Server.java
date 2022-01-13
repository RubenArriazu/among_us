package ud3.practica3.e2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int PORT = 5656;
	
	public static void main(String[] args) {
		
		try {
			
			// Crea un socket para el servidor
			ServerSocket server = new ServerSocket(PORT);
			
			// Espera a que un cliente se conecte al servidor
			Socket client = server.accept();

			// Escucha la paticion del cliente (se espera un numero)
			InputStream inputStream = client.getInputStream();
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			int numberRequest = dataInputStream.readInt();
			// dataInputStream.close();
			// inputStream.close();

			// Devuelve el cuadrado del numero al cliente
			OutputStream outputStream = client.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			int numberResponse = numberRequest * numberRequest;
			dataOutputStream.writeInt(numberResponse);
			dataOutputStream.flush();
			dataOutputStream.close();
			outputStream.close();

			// Cierra el cliente y el servidor
			client.close();
			server.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
