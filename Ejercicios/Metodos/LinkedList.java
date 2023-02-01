package Ejercicios.Metodos;

public class LinkedList<T>
{
    private Node<T> head;

    public LinkedList()
    {
        head = null;
    }

    public void addToHead(T data)
    {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
    }

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

    public T removeFromHead()
    {
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    public T removeFromTail()
    {
        if (head == null)
        {
            return null;
        }
        Node<T> curr = head;
        if (curr.getNext() == null)
        {
            T data = head.getData();
            head = null;
            return data;
        }
        while (curr.getNext().getNext() != null)
        {
            curr = curr.getNext();
        }
        T data = curr.getNext().getData();
        curr.setNext(null);
        return data;
    }

    public void printList()
    {
        Node<T> curr = head;
        while (curr != null)
        {
            System.out.print(curr.getData() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("null");
    }
}
