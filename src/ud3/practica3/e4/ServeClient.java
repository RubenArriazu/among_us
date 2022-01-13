package ud3.practica3.e4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ServeClient extends Thread {

	private Socket client;
	private int clientNumber;

	public ServeClient(Socket client, int clientNumber) {
		this.client = client;
		this.clientNumber = clientNumber;
	}

	@Override
	public void run() {
		OutputStream outputStream;
		try {
			
			outputStream = client.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			dataOutputStream.writeUTF("Bienvenido cliente " + clientNumber);
			
			dataOutputStream.close();
			outputStream.close();
			client.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
