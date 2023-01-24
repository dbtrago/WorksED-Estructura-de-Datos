package Arrayn;

import java.util.ArrayList;

public class ClasePrincipal
{
	static ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	//Metodo estatico con el que se buscan los proveedores añadidos
	static Proveedor buscarProveedor(String nombre)
	{
	    for (Proveedor proveedor : proveedores)
	    {
	        if (proveedor.getNombre().equals(nombre))
	        {	        	
	            return proveedor;
	        }
	    }
	    return null;
	}
    public static void main(String[] args)
    {
        // Agregar un proveedor
        Proveedor proveedor1 = new Proveedor("Juan", "Barranquilla", 10);
        proveedores.add(proveedor1);

        // Informar el nombre de la ciudad y el número de artículos de un proveedor
        Proveedor proveedor = buscarProveedor("Juan");
        System.out.println("Busqueda del proveedor: "+proveedor);
        System.out.println("Nombre del proveedor" + proveedor.getNombre());
        System.out.println("Nombre de la ciudad: " + proveedor.getCiudad());
        System.out.println("Número de artículos: " + proveedor.getNumArticulos());

        // Actualizar el nombre de la ciudad de un proveedor
        proveedor1.setCiudad("Cartagena");
        System.out.println("Nueva localidad: " + proveedor.getCiudad());
        // Actualizar el número de artículos de un proveedor
        proveedor1.setNumArticulos(5);
        System.out.println("Número de articulos actualizados: " + proveedor.getNumArticulos());
    }

}
