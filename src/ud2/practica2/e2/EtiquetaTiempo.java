package ud2.practica2.e2;

import java.time.LocalDateTime;

import javax.swing.JLabel;

public class EtiquetaTiempo extends Thread {

	private JLabel etiquetaHora;

	EtiquetaTiempo(JLabel jLabel) {
		this.etiquetaHora = jLabel;
	}

	@Override
	public void run() {
		super.run();
		LocalDateTime ahora;
		while (true) {
			ahora = LocalDateTime.now();
			int horas = ahora.getHour();
			int minutos = ahora.getMinute();
			int segundos = ahora.getSecond();
			this.etiquetaHora.setText(horas + ":" + minutos + ":" + segundos);	
		}
	}
}
