package ListaEnlazada;

import java.util.LinkedList;

public class ClasePrincipal
{

	public static void main(String[] args)
	{		
		//Se crea la lista enlaza gracias a linkedlist
		//Donde tambien se declara de que tipo de datos se almacenaran en la lista
		
		LinkedList<String> listaEnlazada = new LinkedList<>();
		
		//Se agregan elementos correspondientes a lista
		
        listaEnlazada.add("elemento 1");
        listaEnlazada.add("elemento 2");
        listaEnlazada.add("elemento 3");
        listaEnlazada.add("elemento 4");
        
        //Impresion de la lista enlazada

        System.out.println("\nLista enlazada: " + listaEnlazada);
        
        //Aqui se evidencia el cambio de posición del elemento 1 a la casilla numero 2
        //Aunque no sea así y sea un cambio de indices
        
        String temporal = listaEnlazada.get(0);
        listaEnlazada.set(0, listaEnlazada.get(1));
        listaEnlazada.set(1, temporal);

        //Se re-imprime para ver los cambios

        System.out.println("\nSe pueden ver los cambios de indices\n\nLista enlazada: " + listaEnlazada+"\n");
	}

}
