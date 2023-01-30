package Interfaces;

import javax.swing.*;


public class Main {
	//Para mover la interfaz
	interface Movible {
		void moverArriba();
		void moverAbajo();
		void moverIzquierda();
		void moverDerecha();
	}
	public static void main(String[] args)
	{		
		//Creación del JFrame
		JFrame ventana = new JFrame("Mi ventana");
		ventana.setSize(1915, 1012);
		ventana.setVisible(true);
		ventana.setTitle("OrderEase");
	}

}
