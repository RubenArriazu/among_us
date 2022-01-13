package ud2.practica6.monitores;

public class Main {
	public static void main(String[] args) {
		EquipoAtletismo equipoAtletismo = new EquipoAtletismo();
		for (int i = 0; i < 6; i++) {
			new Atleta(equipoAtletismo, i).run();
		}
	}
}
