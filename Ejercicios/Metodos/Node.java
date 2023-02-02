package Ejercicios.Metodos;

public class Node<T>
{
    private T data;
    private Node<T> next;

    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
    //Retorno de variables
    public T getObject()
    {
        return data;
    }
    //Metodo asignar variables
    public boolean setObject(T Object)
    {
        this.data = Object;
        return true;
    }
    
    public Node<T> getNext()
    {
        return next;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }
}
