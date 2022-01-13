package ud1.practica1;

// Crea un programa sencillo que calcule el factorial de un número
// recibido como parámetro del método main.

public class Ejercicio3 {
	public static void main(String[] args) {
		try {
			long resultado = factorial( Integer.valueOf(args[0]) );
			System.out.println(resultado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}
