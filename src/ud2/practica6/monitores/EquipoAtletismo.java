package ud2.practica6.monitores;

public class EquipoAtletismo {

	private boolean correrVuelta_ = false;
	private boolean entregarTestigo_ = false;

	public EquipoAtletismo() {
		correrVuelta_ = true;
	}
	
	public void correrVuelta(int numeroAtleta) {
		
		while (!correrVuelta_) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Atleta " + numeroAtleta + " | Corre Forrest corre");
		
		correrVuelta_ = false;
		entregarTestigo_ = true;

		synchronized (this) {
			notify();
		}
	
	}


	public void entregarTestigo(int numeroAtleta) {
		
		while (!entregarTestigo_) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Atleta " + numeroAtleta + " | Testigo entregado");
		
		correrVuelta_ = true;
		entregarTestigo_ = false;

		synchronized(this) {
			notify();
		}
	
	}

}
