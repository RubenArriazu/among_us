package ud2.practica4.e2;

public class Caja extends Thread implements Comparable<Caja> {

	private double dineroCaja = 0;
	private Beneficios beneficios;
	
	public Caja(String nombre, Beneficios beneficios) {
		super(nombre);
		this.beneficios = beneficios;
	}

	public int clientesEspera() {
		return 0;
	}

	// Cuidado: Este proceso es infinito y su ejecucion tiene que ser forzada
	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.actualizaBeneficios();
		}
	}

	// ¿Deberia de ser sincronizado?
	@Override
	public int compareTo(Caja caja) {
		return caja.clientesEspera() - this.clientesEspera();
	}

	public synchronized void factura(double precio) {
		dineroCaja += precio;
	}

	public synchronized void actualizaBeneficios() {
		beneficios.suma(dineroCaja);
		dineroCaja = 0;
	}

	public synchronized double getDineroCaja() {
		return dineroCaja;
	}

}
