// Ruben Arriazu Simon
// Testado con OpenJDK 11

package ud1.practica1;

// Crea un programa que invoque al comando Tree sobre la carpeta del
// proyecto y muestra su salida.

import java.io.IOException;
import java.io.InputStream;

class Ejercicio1 {
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder().command("CMD", "/C", "TREE");
		
		try {
			
			// Crea el proceso y lee el codigo de salida
			Process p = pb.start();
			int salida = p.waitFor();
			
			// Obtiene la salida estandar o el error
			InputStream is = salida == 0 ? p.getInputStream() : p.getErrorStream();
			
			// Muestra el valor del stream por pantalla
			int aux = 0;
			while ((aux = is.read()) != -1) {
				System.out.print((char)aux);
			}
			
			// Cierra el stream
			is.close();

			// Muestra el valor de salida
			System.out.println("Valor de salida: " + salida);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
