package ud2.simulacion_examen;

import java.util.concurrent.Semaphore;

public class Prueba {

	private String nombre;
	private int tiempoMin;
	private int tiempoMax;
	private Semaphore tripulantesSimultaneos;

	public Prueba(String nombre, int tiempoMin, int tiempoMax, int tripulantesSimultaneos) {
		this.nombre = nombre;
		this.tiempoMin = tiempoMin;
		this.tiempoMax = tiempoMax;
		this.tripulantesSimultaneos = new Semaphore(tripulantesSimultaneos);
	}

	public String getNombre() {
		return nombre;
	}


	public Semaphore getTripulantesSimultaneos() {
		return tripulantesSimultaneos;
	}

	public int duracionPrueba() {
		return tiempoMin + (int) ((tiempoMax - tiempoMin) * Math.random());
	}

}
