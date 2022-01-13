package ud3.practica4;

import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String mensaje = "";
		for (;;) {
			String cadena = scanner.next();
			if (cadena.equals("*")) {
				break;
			}
			mensaje += cadena;
		}
		scanner.close();
	}
}
