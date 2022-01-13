package ud1.practica1;

// Crea un programa en Java que admita argumentos desde el método main()
// y devuelva con System.exit() los siguientes valores:
//     Si el número de argumentos es <1 debe devolver 1
//     Si el argumento es una cadena debe devolver 2
//     Si el argumento es un número menor que 0 debe devolver 3
//     En cualquier otro caso devolverá 0.


public class Ejercicio7 {
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.exit(1);
		} else if (args.length > 1) {
			System.exit(2);
		} else if (esNumero(args[0]) && Integer.valueOf(args[0]) < 0) {
			System.exit(3);
		} else {
			System.exit(0);
		}
	}

	private static Boolean esNumero(String texto) {
		try {
			Integer.valueOf(texto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
