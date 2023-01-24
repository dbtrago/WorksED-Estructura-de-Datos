package Arrayn;

import java.util.ArrayList;

public class Proveedor
{
	//Variables proveedor
	
	String nombre;
    String ciudad;
    int numArticulos;
    ArrayList<Articulo> articulos;

    //Constructor de Proveedor

    public Proveedor(String nombre, String ciudad, int numArticulos)
    {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.numArticulos = numArticulos;
        this.articulos = new ArrayList<Articulo>();
    }
    
    //Getters and setters
    
    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    public void setNumArticulos(int numArticulos)
    {
        this.numArticulos = numArticulos;
    }    

    public String getNombre()
    {
        return this.nombre;
    }

    public String getCiudad()
    {
        return this.ciudad;
    }

    public int getNumArticulos()
    {
        return this.numArticulos;
    }
    
    //Metodo para agregar un articulo al proveedor
    public void addArticulo(Articulo articulo) 
    {
        this.articulos.add(articulo);
    }
}
