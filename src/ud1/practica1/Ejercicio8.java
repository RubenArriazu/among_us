package ud1.practica1;

import java.io.IOException;

// Realiza un programa para ejecutar Ejercicio7 y ejecutalo comprobando que
// el código de salida es correcto en todos los casos.

public class Ejercicio8 {

	private static int numeroTest = 0;
	private static int testFallidos = 0;
	
	public static void main(String[] args) {
		test(codigoSalida(), 1);
		test(codigoSalida(new String[]{"a", "b"}), 2);
		test(codigoSalida(new String[]{"a", "b", "c"}), 2);
		test(codigoSalida("-1"), 3);
		test(codigoSalida("1"), 0);
		test(codigoSalida("a"), 0);
		resumen();
	}
	
	private static int codigoSalida(String argumento) {
		return codigoSalida(new String[]{argumento});
	}
	
	private static int codigoSalida() {
		return codigoSalida(new String[]{});
	}
	
	private static int codigoSalida(String[] argumentos) {
		
		// Array de la forma: java + programa + argumentos
		// que es el comando utilizado por el ProcessBuilder
		String[] comando = new String[2 + argumentos.length];
		comando[0] = "java";
		comando[1] = "src/ud1/practica1/Ejercicio7.java";
		for (int i=0; i < argumentos.length; i++) {
			comando[i+2] = argumentos[i];
		}
		
		// Ejecucion del programa
		// En caso de que algo salga mal, se devuelve el valor -1
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			Process p = pb.start();
			return p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
	
	private static void test(int codigo_prueba, int codigo_esperado) {
		numeroTest++;
		if (codigo_prueba == codigo_esperado) {
			System.out.println("[" + numeroTest + "] Exito");
			return;
		}
		testFallidos++;
		System.out.println("[" + numeroTest + "] Fallo");
	}
	
	private static void resumen() {
		double porcetajeFallido = (double) testFallidos / (double)numeroTest * 100;
		System.out.println(
			"\n" + testFallidos + " de " + numeroTest + " pruebas han fallado ("
			+ String.format("%.2f", porcetajeFallido) + "%)"
		);		
	}
	
}
