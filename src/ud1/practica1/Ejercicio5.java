package ud1.practica1;

// Crea un programa que reciba desde los argumentos del método Main() un nombre y
// lo visualice en pantalla. Utiliza valor 0 para una finalización correcta y valor
// -1 para el caso de que no se hayan introducido argumentos correctos en el main.

public class Ejercicio5 {
	public static void main(String[] args) {
		
		if (args.length > 0) {
			for (String arg : args) {
				System.out.print(arg + " ");
			}
			System.exit(0);
		} else {
			System.exit(-1);
		}
	
	}
}
