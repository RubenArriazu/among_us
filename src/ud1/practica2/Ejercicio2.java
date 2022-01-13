package ud1.practica2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Crea un programa en Java para ejecutar el Ejercicio1 y utiliza el flujo de salida
// para introducir los valores de la entrada estándar. Realiza comprobaciones tanto 
// con entradas correctas como con incorrectas. Mostrar la salida del proceso y su
// valor de salida y, en su caso, el mensaje de error.


public class Ejercicio2 {
	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Los argumentos de entrada son 2");
			System.err.println("Ejercicio2 a:[Integer] b:[Integer]");
			System.exit(1);
		}
		
		try {

			Process p = new ProcessBuilder("java", "src/ud1/practica2/Ejercicio1.java").start();

			OutputStream os = p.getOutputStream();
			os.write((args[0] + " " + args[1]).getBytes());
			os.flush();
			os.close();

			// Ejecuta el proceso y mustra su salida estandar o error
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
