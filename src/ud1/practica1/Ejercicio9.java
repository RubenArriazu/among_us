package ud1.practica1;

// Crea un programa que visualice 5 veces la cadena que se le envía como
// parámetro del main(). Si no se le envía ninguna cadena debe mostrar un
// mensaje indicandolo y finalizar el programa con valor de salida 1.

public class Ejercicio9 {
	public static void main(String[] args) {
		
		if (args.length != 0) {
			for (int i=0; i < 5; i++)
				System.out.println(args[0]);
			System.exit(0);
		}
		System.exit(1);
	
	}
}
