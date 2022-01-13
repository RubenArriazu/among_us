package ud2.practica6.syncro;

public class EquipoAtletismo {
	
	public synchronized void correrVuelta(int numeroAtleta) {
		System.out.println("Atleta " + numeroAtleta + " | Corre Forrest corre");
	}
	
	public synchronized void entregarTestigo(int numeroAtleta) {
		System.out.println("Atleta " + numeroAtleta + " | Testigo entragado");
	}

}
