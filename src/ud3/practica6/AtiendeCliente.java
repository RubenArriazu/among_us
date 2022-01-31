package ud3.practica6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AtiendeCliente extends Thread {

	private Socket cliente;

	AtiendeCliente(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
		super.run();
		try {

			// Logs del cliente
			System.out.println(cliente.getInetAddress() + " from port " + cliente.getPort());

			// Abre sockets
			InputStream inputStream = cliente.getInputStream();
			DataInputStream dataInput = new DataInputStream(inputStream);
			OutputStream outputStream = cliente.getOutputStream();
			DataOutputStream dataOutput = new DataOutputStream(outputStream);

			// Penciones y respuestas
			String entrada;
			do {
				entrada = dataInput.readUTF();
				dataOutput.writeUTF(alternaMayusMinus(entrada));
			} while (!entrada.trim().equals("EOT"));

			// Cierra los sockets y el cliente
			inputStream.close();
			dataInput.close();
			outputStream.close();
			dataOutput.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String alternaMayusMinus(String texto) {
		String nuevoTexto = "";
		int i = 0;
		for (String caracter : texto.split("")) {
			if (i % 2 == 0) {
				nuevoTexto += caracter.toUpperCase();
			} else {
				nuevoTexto += caracter.toLowerCase();
			}
			i++;
		}
		return nuevoTexto;
	}

}
