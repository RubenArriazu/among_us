package ud2.practica2.e2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Hora {
	Hora() {
		JFrame jFrame = new JFrame();
		jFrame.setSize(200, 200);
		jFrame.setLayout(new FlowLayout());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel etiquetaHora = new JLabel("Hola mundo");
		jFrame.add(etiquetaHora);
		
		EtiquetaTiempo etiquetaTiempo = new EtiquetaTiempo(etiquetaHora);
		etiquetaTiempo.start();
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});
		jFrame.add(botonSalir);
		
		jFrame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Hora();
			}
		});
	}
}
