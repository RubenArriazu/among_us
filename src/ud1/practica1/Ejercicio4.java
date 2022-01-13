package ud1.practica1;

// Crea un programa que, ejecutando Ejercicio3, nos calcule el cuadrado
// del factorial de un número dado por teclado.

import java.util.Scanner;
import java.io.File;
import java.io.InputStream;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Introduce un numero: ");
			int n = scan.nextInt();
			scan.close();
			
			// Ejecuta programa para calcular factorial
			ProcessBuilder pb = new ProcessBuilder("java", "src/ud1/practica1/Ejercicio3.java", Integer.toString(n));
			pb.directory(new File("."));
			Process p = pb.start();
			int salida = p.waitFor();

			// Obtiene la salida estandar o el error
			InputStream is = salida == 0 ? p.getInputStream() : p.getErrorStream();

			// Muestra el valor del stream por pantalla
			int aux = 0;
			while ((aux = is.read()) != -1) {
				System.out.print((char)aux);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}