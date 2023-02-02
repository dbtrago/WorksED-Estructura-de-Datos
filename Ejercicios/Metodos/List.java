package Ejercicios.Metodos;

public class List<T>
{
    private Node<T> head;

    public List()
    {
        head = null;
    }
    //Añade la cabeza
    public void addToHead(T data)
    {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
    }
    
    //Añade al final de la lista enlazada
    public void addToTail(T data)
    {
        Node<T> newNode = new Node<>(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        Node<T> curr = head;
        while (curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        curr.setNext(newNode);
    }
    //Quita la cabeza
    public T removeFromHead()
    {
        T data = head.getObject();
        head = head.getNext();
        return data;
    }
    //Quita de la cola
    public T removeFromTail()
    {
        if (head == null)
        {
            return null;
        }
        Node<T> curr = head;
        if (curr.getNext() == null)
        {
            T data = head.getObject();
            head = null;
            return data;
        }
        while (curr.getNext().getNext() != null)
        {
            curr = curr.getNext();
        }
        T data = curr.getNext().getObject();
        curr.setNext(null);
        return data;
    }
    //Impresión de la lista
    public void printList()
    {
        Node<T> curr = head;
        while (curr != null)
        {
            System.out.print(curr.getObject() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("null");
    }
}
