package ud1.practica2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Crea un programa en Java que ejecute el Ejercicio 3
// y muestre su resultado y su valor de salida.

public class Ejercicio4 {
	public static void main(String[] args) {
		
		try {
			
			// Texto que enviar
			String texto = "Were no strangers to love\n" +
				"You know the rules and so do I\n" +
				"A full commitment's what I'm thinking of\n" +
				"You wouldn't get this from any other guy\n" +
				"I just wanna tell you how I'm feeling\n" +
				"Gotta make you understand\n" +
				"Never gonna give you up\n" +
				"Never gonna let you down\n" +
				"Never gonna run around and desert you\n" +
				"Never gonna make you cry\n" +
				"Never gonna say goodbye\n" +
				"Never gonna tell a lie and hurt you\n";

			// Termina texto con caracter * (representa EOF)
			texto += " *";
			
			// Crea un proceso que envia el texto al a la entrada estandar del Ejercicio3
			Process p = new ProcessBuilder("java", "src/ud1/practica2/Ejercicio3.java").start();
			OutputStream os = p.getOutputStream();
			os.write(texto.getBytes());
			os.flush();
			os.close();

			// Ejecuta el proceso y mustra su salida (tanto salida estandar como error)
			int salida = p.waitFor();
			InputStream is = salida == 0 ? p.getInputStream() : p.getErrorStream();
			int aux;
			while ((aux = is.read()) != -1) {
				System.out.print((char)aux);
			}
			is.close();


		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
