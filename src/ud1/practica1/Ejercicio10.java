package ud1.practica1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

// Crea un programa que ejecute Ejercicio9, este programa debe solicitar
// por teclado una cadena y enviarla al proceso, mostrando en ambos casos
// el resultado por pantalla.

public class Ejercicio10 {
	public static void main(String[] args) {
		
		// Pide cadena al usuario
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce una cadena: ");
		String cadena = scan.next();
		scan.close();

		// Envia al proceso (ejercicio 9) la cadena y muestra la salida
		ProcessBuilder pb = new ProcessBuilder("java", "src/ud1/practica1/Ejercicio9.java", cadena);
		try {
			
			Process p = pb.start();
			int salida = p.waitFor();
			InputStream is = salida == 0 ? p.getInputStream() : p.getErrorStream();
			
			int aux = 0;
			while ((aux = is.read()) != -1) {
				System.out.print((char)aux);
			}
			is.close();
			System.out.println("Codigo de salida: " + salida);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
