package ud1.practica2;

import java.io.File;

// Crea un programa Java que ejecute el Ejercicio 3 recogiendo el valor
// de entrada desde un fichero y almacenando el resultado y el valor de
// salida del proceso en sendos ficheros.

public class Ejercicio6 {
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("java", "src/ud1/practica2/Ejercicio3.java");
		pb.redirectInput(new File("entrada"));
		pb.redirectOutput(new File("salida"));
		pb.redirectError(new File("error"));
		try {
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
