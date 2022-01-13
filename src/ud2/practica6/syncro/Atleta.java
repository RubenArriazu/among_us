package ud2.practica6.syncro;

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
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
