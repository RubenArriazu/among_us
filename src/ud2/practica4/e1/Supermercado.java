package ud2.practica4.e1;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Semaphore;

public class Supermercado {
	public static void main(String[] args) {

		final int NUMERO_CAJAS = 5;
		final int NUMERO_CLIENTES = 30;

		Beneficios beneficios = new Beneficios();
		Semaphore semaforoBeneficios = new Semaphore(1);

		// Prepara las cajas
		SortedSet<Caja> cajas = new TreeSet<Caja>();
		for (int i = 0; i < NUMERO_CAJAS; i++) {
			Caja caja = new Caja("Caja" + i, semaforoBeneficios, beneficios);
			caja.start();
			cajas.add(caja);
		}

		// Inicia hilos con los clientes
		Cliente[] clientes = new Cliente[NUMERO_CLIENTES];
		for (int i = 0; i < NUMERO_CLIENTES; i++) {
			clientes[i] = new Cliente("Cliente" + i, cajas);
			clientes[i].start();
		}

		// Espera a la ejecucion de tos los hilos clientes
		for (Cliente cliente : clientes) {
			try {
				cliente.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Espera a que se actualizen los beneficios
		for (Caja caja : cajas) {
			while (true) {
				if (caja.getDineroCaja() == 0) {
					break;
				}
			}
		}

		// Mustra los beneficios
		System.out.println("Beneficios: " + beneficios.getBeneficios());

		// Finaliza la ejecucion del programa
		System.exit(0);

	}
}
