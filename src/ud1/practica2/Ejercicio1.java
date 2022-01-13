package ud1.practica2;

import java.util.Scanner;

// Crea un programa en Java que lea dos números desde la entrada estándar y
// visualice su suma. Controlar que lo introducido por teclado sean dos números
// enteros, en caso contrario el programa debe finalizar con valor 1 e indicar
// el error por la salida de error estándar.


public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try {
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.print(a + b);
		} catch (Exception e) {
			System.err.println(e);
			scan.close();
			System.exit(1);
		}
		
		scan.close();
	}
}
