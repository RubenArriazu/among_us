package ud2.practica6.syncro;

public class Main {
	public static void main(String[] args) {
		EquipoAtletismo equipoAtletismo = new EquipoAtletismo();
		for (int i = 0; i < 5; i++) {
			new Atleta(equipoAtletismo, i).run();
		}
	}
}
