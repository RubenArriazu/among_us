package ud2.practica4.e1;

import java.util.concurrent.Semaphore;

public class Caja extends Thread implements Comparable<Caja> {

	private Semaphore semaphore = new Semaphore(1, true);
	private double dineroCaja = 0;
	private Beneficios beneficios;
	private Semaphore semaforoBeneficios;
	
	public Caja(String nombre, Semaphore semaforoBeneficios, Beneficios beneficios) {
		super(nombre);
		this.semaforoBeneficios = semaforoBeneficios;
		this.beneficios = beneficios;
	}

	public int clientesEspera() {
		return semaphore.getQueueLength();
	}

	@Override
	public void run() {
		super.run();
		for (int i=0; i < 10; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.actualizaBeneficios();
		}
	}

	@Override
	public int compareTo(Caja caja) {
		return caja.clientesEspera() - this.clientesEspera();
	}

	public void factura(double precio) {
		try {
			semaphore.acquire();
			dineroCaja += precio;
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void actualizaBeneficios() {
		boolean actualizado = false;
		do {
			if (semaforoBeneficios.tryAcquire()) {
				beneficios.suma(dineroCaja);
				semaforoBeneficios.release();
				actualizado = true;
			}
		} while (!actualizado);

		dineroCaja = 0;
	}

	public Double getDineroCaja() {
		return dineroCaja;
	}

}
