package ud2.practica4.e2;

import java.util.SortedSet;

public class Cliente extends Thread {

	private double tiempoMaximo = 3;
	private double tiempoMinimo = 0.2;
	
	private double precioMaximo = 3;
	private double precioMinimo = 0.2;

	SortedSet<Caja> cajas;

	Cliente(String nombre, SortedSet<Caja> cajas) {
		super(nombre);
		this.cajas = cajas;
	}

	@Override
	public void run() {
		super.run();

		// Tiempo aleatorio de entrada y compra en el supermercado
		double timepoEspera = tiempoMinimo + (tiempoMaximo - tiempoMinimo) * Math.random();
		try {
			sleep( Math.round(timepoEspera * 1000) );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Precio de la compra
		double precio = precioMinimo + (precioMaximo - precioMinimo) * Math.random();
		System.out.println(getName() + " - Precio: " + precio);

		// Paga en caja
		var caja = cajas.first();
		caja.factura(precio);
	}
}
