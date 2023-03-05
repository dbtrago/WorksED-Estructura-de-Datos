package Paquete;

import interfaces.Node;

public class LinkedListNode<T> implements Node<T>
{
    //Atributos
    private T object;
    LinkedListNode next;
    LinkedListNode  prev;
    
    public LinkedListNode()
    {
        this.object = null;
        this.next = null;
        this.prev = null;
    }

    public LinkedListNode(T object)
    {
        this.object = object;
        this.next = null;
    }
    public LinkedListNode(T object, LinkedListNode next,LinkedListNode prev)
    {
        this.object = object;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public boolean setObject(T object)
    { //Validar que el objeto puede ser almacenado en la linkedlist
        this.object = object;
        return true;
    }
    
    
    
    @Override
    public T getObject()
    {
        return this.object;
    }

    @Override
    public boolean isEquals(T object)
    {
        return this.object.toString().equals(object.toString());

    }

    @Override
    public String toString()
    {
        return "LinkedListNode{" + "object=" + object + ", next=" + next + "prev = "+ prev+'}';
    }

    @Override
    public Node<T> next()
    {
        return null;
    }
    
	@Override
	public Node<T> prev()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
