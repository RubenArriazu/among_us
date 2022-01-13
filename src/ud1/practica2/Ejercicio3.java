package ud1.practica2;

import java.util.ArrayList;
import java.util.Scanner;

// Crea un programa en Java que lea cadenas de texto a través de la entrada
// estándar hasta que el usuario introduzca un *. Después debe mostrar esas
// cadenas concatenadas y en mayúsculas.

public class Ejercicio3 {
	public static void main(String[] args) {
		
		// Abre un Scanner
		Scanner scan = new Scanner(System.in);
		
		// Crea una lista de strings
		ArrayList<String> cadenas = new ArrayList<String>();
		
		// Añade a la lista la palabra hasta que se introduzca *
		// y cierra el Scanner
		while (true) {
			String cadena = scan.next();
			if (cadena.equals("*")) {
				break;
			}
			cadenas.add(cadena); 
		}
		scan.close();
		
		// Mustra la cada cadena en maysculas  
		for (String cadena : cadenas) {
			System.out.print(cadena.toUpperCase());
			System.out.print(" ");
		}

	}
}
