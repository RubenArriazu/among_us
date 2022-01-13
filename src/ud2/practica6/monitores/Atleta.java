package ud2.practica6.monitores;

public class Atleta extends Thread {

	private EquipoAtletismo equipoAtletismo;
	private int numeroAtleta;

	public Atleta(EquipoAtletismo equipoAtletismo, int numeroAtleta) {
		this.equipoAtletismo = equipoAtletismo;
		this.numeroAtleta = numeroAtleta;
	}
	
	@Override
	public void run() {
		super.run();
		equipoAtletismo.correrVuelta(numeroAtleta);
		equipoAtletismo.entregarTestigo(numeroAtleta);
	}
}
