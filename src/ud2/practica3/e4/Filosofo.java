package ud2.practica3.e4;

import java.util.concurrent.Semaphore;

public class Filosofo extends Thread {

	private int posicionTenedorA;
	private int posicionTenedorB;
	private Semaphore[] tenedores;
	
	public Filosofo(String nombre, int posicionTenedorA, int posicionTenedorB, Semaphore[] tenedores) {
		super(nombre);
		this.posicionTenedorA = posicionTenedorA;
		this.posicionTenedorB = posicionTenedorB;
		this.tenedores = tenedores;
	}
	
	private void comer(int iteracion) {
		System.out.println("Comiendo - Filosofo:" + getName() + " - Iter:" + iteracion);
	}
	
	private void pensar(int iteracion) {
		System.out.println("Pensando - Filosofo:" + getName() + " - Iter:" + iteracion);
	}

	@Override
	public void run() {
		super.run();
		int i = 1;
		while (i <= 100) {
			pensar(i);
			if (tenedores[posicionTenedorA].tryAcquire()) {
				if (tenedores[posicionTenedorB].tryAcquire()) {
					comer(i);
					i++;
					tenedores[posicionTenedorB].release();
				}
				tenedores[posicionTenedorA].release();
			}
		}
	}

}
