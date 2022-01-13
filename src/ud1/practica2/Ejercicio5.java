package ud1.practica2;

import java.io.File;

// Crea un programa Java que ejecute el Ejercicio 1 recogiendo el valor de
// entrada desde un fichero y almacenando el resultado y, en su caso, la
// salida de error en sendos ficheros.

public class Ejercicio5 {
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("java", "src/ud1/practica2/Ejercicio1.java");
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
