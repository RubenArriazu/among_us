package practica1;

import java.io.IOException;
import java.io.InputStream;

class Ejercicio1 {
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder().command("CMD", "/C", "TREE");
		try {
			
			// Crea el proceso y lee el codigo de salida
			Process p = pb.start();
			int salida = p.waitFor();
			
			if (salida == 0) {
				// Lee la entrada estandar para sacarla por pantalla
				InputStream is = p.getInputStream();
				int aux = 0;
				while ((aux = is.read()) != -1) {
					System.out.print((char)aux);
				}
				is.close();
			} else {
				// Lee la entrada estandar para sacarla por pantalla
				InputStream es = p.getErrorStream();
				int aux = 0;
				while ((aux = es.read()) != -1) {
					System.out.print((char)aux);
				}
				es.close();
			}

			// Imprime el valor de salida
			System.out.println("Valor de salida: " + salida);
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}