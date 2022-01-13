// Ruben Arriazu Simon
// Testado con OpenJDK 11

package ud1.practica1;

// Partiendo del código anterior, crea un programa que muestre el árbol de carpetas
// de un directorio recibido como parámetro por la entrada estándar. 

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

class Ejercicio2 {
	public static void main(String[] args) {

		// Pide al usuario una ruta
		Scanner scan = new Scanner(System.in);
		String ruta;
		
		do {
			try {
				System.out.print("Introduce una ruta: ");
				ruta = scan.nextLine();
			} catch (Exception e) {
				System.err.println("[ERROR]");
				ruta = "";
			}
		} while (ruta.isEmpty());

		scan.close();
		
		// Crea un proceso con el comando TREE
		ProcessBuilder pb = new ProcessBuilder().command("CMD", "/C", "TREE", "/A", ruta);
		
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
