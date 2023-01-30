package Interfaces;

import javax.swing.*;


public class Main
{
	public static JFrame crearVentana()
	{
		//Creación de ventana
        JFrame jframe = new JFrame();
        jframe.setSize(1900, 1060);
        jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton boton = new JButton("Hola");
        boton.setBounds(100, 100, 80, 30);

        jframe.add(boton);
        return jframe;
    }
	public static void main(String[] args)
	{	
        JFrame ventana = crearVentana();
		ventana.setVisible(true);
	}

}
