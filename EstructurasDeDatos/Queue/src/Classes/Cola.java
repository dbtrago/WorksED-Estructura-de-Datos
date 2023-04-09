package Classes;

import java.util.Arrays;

public class Cola implements interfaces.Cola
{
    //Atributos
    LinkedList List = new LinkedList();

    public Cola()//Constructor
    {
        this.List = new LinkedList<>();
    }

    @Override
    public void clear()
    {
        List.clear();//Limpia la lista enlazada
    }

    @Override
    public boolean isEmpty()
    {
        return List.isEmpty();
    }

    @Override
    public Object extract()
    {
        if(isEmpty())
        {
            System.out.println("La lista esta vacia, no hay nada que extraer");
            return null;
        }
        else
        {
            Object temp = List.head.getObject();
            List.remove(List.head);
            return temp;
        }
    }

    @Override
    public boolean insert(Object object)
    {
        if(object != null)
        {
            List.add(object);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int size()
    {
        return List.size();
    }

    @Override
    public boolean search(Object object)
    {
        return List.contains(object);
    }

    @Override
    public void sort()
    {
        if (List.isEmpty() || List.size() == 1) {
            return; // No se requiere ordenar si la lista está vacía o tiene solo un elemento
        }

        // Se convierte la lista en un array para poder utilizar el método sort de Arrays
        Object[] arr = List.toArray();
        Arrays.sort(arr);

        // Se reconstruye la lista a partir del array ordenado
        List.clear();
        for (Object obj : arr) {
            List.add(obj);
        }
    }

    @Override
    public void reverse()
    {

        if (List.isEmpty() || List.size() == 1)
        {
            return;
        }

        LinkedListNode actual = List.head;
        LinkedListNode temp = null;

        //Se recorren los nodos de la lista y se cambia su orden
        while (actual != null) {
            temp = (LinkedListNode) actual.prev();
            actual.setPrev(actual.getNext());
            actual.setNext(temp);
            actual = (LinkedListNode) actual.prev();
        }

        temp = List.head;
        List.head = List.tail;
        List.tail = temp;

    }
    public void toStrings()
    {
        List.toString();
    }
}

