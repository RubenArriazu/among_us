package ud3.practica2.e2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

	static final String ADDRESS = "localhost";
	static final int PORT = 6000;

	public static void main(String[] args) {
		
		try {
			Socket cliente = new Socket(ADDRESS, PORT);
			
			OutputStream out = cliente.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(out);
			
			String mensaje = "Adios Don Pepito";
			dataOutputStream.writeUTF(mensaje);

			dataOutputStream.close();
			out.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
