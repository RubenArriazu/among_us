package ud1.practica1;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// Crea un programa para ejecutar Ejercicio5. Muestra por pantalla el valor
// de salida comprobando tanto el caso correcto como el incorrecto.

public class Ejercicio6 {
	public static void main(String[] args) {

		// Pide nombre
		System.out.print("Introduce un nombre: ");
		Scanner scan = new Scanner(System.in);
		String nombre = scan.nextLine();
		scan.close();

		// Ejecuta prorgama ejercicio5
		ProcessBuilder pb = new ProcessBuilder("java", "src/ud1/practica1/Ejercicio5.java", nombre);
		pb.directory(new File("."));

		Process process = null;
		try {
			process = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int codigoSalida = -1;
		try {
			codigoSalida = process.waitFor();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		// Obtiene la salida estandar o el error
		InputStream inputStream = codigoSalida == 0 ? process.getInputStream() : process.getErrorStream();

		System.out.println("[Codigo de salida: " + codigoSalida + "]");

		int aux = 0;
		try {
			while ((aux = inputStream.read()) != -1) {
				System.out.print((char) aux);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
