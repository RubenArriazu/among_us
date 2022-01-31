package ud3.hack_streams;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

class StreamExperiment {

	private static final String ADDRESS = "localhost";
	private static final int PORT = 5050;

	public static void main(String[] args) {
		try {
			
			if (args[0].equals("unknown")) {
				
				Socket client = new Socket(ADDRESS, PORT);
				DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
				dataOutputStream.writeUTF("Hello World");
				dataOutputStream.close();
				client.close();
			
			} else if (args[0].equals("closed")) {
				
				Socket client = new Socket(ADDRESS, PORT);
				OutputStream outputStream = client.getOutputStream();
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
				dataOutputStream.writeUTF("Hello World");
				dataOutputStream.close();
				outputStream.close();
				client.close();
			
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
