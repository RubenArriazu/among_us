package ud2.simulacion_examen;

public class Main {

	private static final int NUMERO_TRIPULANTES = 10;
	private static final int TIEMPO_PARTIDA = 5000;

	public static void main(String[] args) {
		
		Tripulante[] tripulantes = new Tripulante[NUMERO_TRIPULANTES];

		// Espera a los jugadores
		for (int t = 0; t < NUMERO_TRIPULANTES; t++) {
			tripulantes[t] = new Tripulante(t);
		}

		// Cuenta atras para comenzar la partida
		for (int i = 5; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Comienza la partida");

		// Comienza la partida
		for (int t = 0; t < NUMERO_TRIPULANTES; t++) {
			tripulantes[t].start();
		}

		// Termina la partida
		try {
			Thread.sleep(TIEMPO_PARTIDA);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int t = 0; t < NUMERO_TRIPULANTES; t++) {
			tripulantes[t].stop();
		}

		// Mustra al vencedor
		System.out.println();
		System.out.println("********************************************************");
		System.out.println("****************** PARTIDA TERMINADA *******************");
		System.out.println("********************************************************");
		System.out.println();
		
		if (Tripulante.numeroTripulantesTerminado == NUMERO_TRIPULANTES) {
			System.out.println("Todas las pruebas completadas. Ganan los tripulantes");
		} else {
			System.out.println("Tiempo agotado, ganan los impostores");
		}
	
	}
}
