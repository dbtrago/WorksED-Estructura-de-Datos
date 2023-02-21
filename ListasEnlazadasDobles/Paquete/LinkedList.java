package Paquete;

import interfaces.List;
import interfaces.Node;

import java.io.OptionalDataException;
import java.util.Arrays;
import java.util.Iterator;

public class LinkedList<T> implements List<T> {
    public LinkedListNode head; //Es una referencia, una dirección de memoria
    public LinkedListNode tail;

    public LinkedList() { //permite iniciar una lista sin que tenga ningun nodo
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) //Main de pruebas
    {

    }

    public boolean add(T object)//1
    {
        boolean ack = false;

        try
        {
            if (object != null)
            {
                if (isEmpty())
                {
                    this.head = tail = new LinkedListNode(object);
                }
                else
                {
                    tail.next = new LinkedListNode(object);
                    tail = (LinkedListNode) tail.next;
                }
                return true;
            }

        }
        catch (Exception e)// En caso de errores
        {
            e.printStackTrace();
        }
        finally
        {
            return ack; //retornar el valor booleano que indica si hubo una insercion o no
        }
    }

    @Override
    public boolean add(Node node, T object) //2
    {
        boolean ack = false;
        try
        {
            node.setObject(object);
        }
        catch (Exception e)// En caso de errores
        {
            e.printStackTrace();
        }
        finally
        {
            return ack; //no se probado
        }
    }

    public boolean add(Node node, Node next)// 3
    {
        boolean ack = false;
        try
        {
            if (node == null && next == null)//retorna falso si ambos nodos ingresados no contienen información
            {
                return false;
            }
            Object temp = node.getObject();
            next.setObject(temp);
            return true;
        }
        catch (Exception e)// En caso de errores
        {
            e.printStackTrace();
        }
        finally
        {
            return ack;
        }
    }


    public boolean add(T[] objects)// 4
    {
        boolean ack = false;
        try
        {
            if (objects != null)
            {
                if (isEmpty())
                {
                    this.head = tail = new LinkedListNode(objects, head);
                } else {
                    tail.next = new LinkedListNode(objects, head);
                    tail = (LinkedListNode) tail.next;
                }
                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

            return ack;
        }
    }


    public boolean add(Node node, T[] objects)//5
    {
        boolean ack = false;

        try
        {
            if (objects != null)
            {
                if (isEmpty())
                {
                    this.head = tail = new LinkedListNode(node, head);
                } else {
                    tail.next = new LinkedListNode(node, tail);
                    tail = (LinkedListNode) tail.next;
                }
                return true;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return ack;
        }
    }

    public boolean addFirst(T object)//6
    {
        if (isEmpty())
        {
            head = new LinkedListNode(object, tail);
            return true;
        }
        LinkedListNode nuevoNodo = new LinkedListNode(object, head);
        nuevoNodo.next = head;
        head = nuevoNodo;
        return true;
    }

    public boolean addFirst(T[] objects)//7
    {
        if (isEmpty())
        {
            head = new LinkedListNode(objects, tail);
            return true;
        }

        LinkedListNode nuevoNodo = new LinkedListNode(objects, head);
        nuevoNodo.next = head;
        head = nuevoNodo;
        return true;
    }

    public boolean addLast(T object)//8
    {
        if (isEmpty())
        {
            head = new LinkedListNode(object, null);
            return true;
        }

        LinkedListNode nodoMensajero = head;

        while (nodoMensajero.next == null)
        {
            nodoMensajero = (LinkedListNode) nodoMensajero.next;
        }

        nodoMensajero.next = new LinkedListNode(object, null);
        return true;
    }

    public boolean addLast(T[] objects)//9
    {
        boolean ack = false;
        try {
            for (T object : objects)
            {
                addLast(object);
            }
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return ack;
        }
    }

    public boolean clear()//10
    {
        boolean ack = false;
        try {
            head = null;
            tail = null;
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return ack;
        }
    }

    @Override
    public List clone()//11
    {
        LinkedList clonedList = new LinkedList();
        Node current = head;
        Node clonedCurrent = null;
        try
        {
            while (current != null)
            {
                Object tempo = new Object(); //Crea un objeto el cual almacena temporalmente la información
                tempo = current.getObject();

                if (clonedList.head == null)
                {
                    clonedList.head = new LinkedListNode(tempo);
                    clonedCurrent = clonedList.head;
                }
                else
                {
                    ((LinkedListNode<?>) clonedCurrent).next = new LinkedListNode(tempo);
                    clonedCurrent = ((LinkedListNode<?>) clonedCurrent).next;
                }
                current = ((LinkedListNode<?>) current).next;
            }
            return clonedList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }

    }

    @Override
    public boolean contains(T object)//12
    {
        boolean ask = false;
        try
        {
            if (!contains(object))
            {
                return false;
            }
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return ask;
        }
    }
    @Override
    public boolean contains(T[] objects)//13
    {
        boolean ask = false;
        try
        {
            for (T object : objects)
            {
                if (!contains(object))
                {
                    return false;
                }
            }
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            return ask;
        }
    }
    @Override
    public Node nodeOf(T object)//15 Retorna el nodo del objeto especificado, o null si no contiene el objeto
    {
        try
        {
            LinkedListNode current = head;
            while (current != null)
            {
                if (current.equals(object))
                {
                    return current;
                }
                current = (LinkedListNode) current.next;
            }
            return null;
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            return null;
        }
    }

    public boolean isEmpty()//16 verifica si el nodo esta vacio
    {
        boolean ask = false;
        try
        {
            if (head == null)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return ask;
        }
    }
    public T get()//17 Retorna el objeto del último nodo insertado.
    {
        try
        {
            if (head == null)//Verificar que la cabeza este vacia
            {
                return null;
            }
            LinkedListNode newNodo = head;//Variable que recorre los nodos
            while (newNodo.next != null)
            {
                newNodo = (LinkedListNode) newNodo.next;
            }
            return (T) newNodo.getObject();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public T get(Node node)//18 Retorna un objeto de la posición del nodo especificado
    {
        int index = 0;
        Node current = head;
        try
        {
            if (head == null || node == null)
            {
                return null;
            }
            while (current != null)
            {
                if (current == node)
                {
                    break;
                }
                current = ((LinkedListNode<?>) current).next;
                index++;
            }
            if (current != null)
            {
                return (T) current.getObject();
            } else {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }

    }

    @Override
    public T getPrevious(Node node)//19
    {
        try
        {
            if (head == null || head == node)
            {
                return null;
            }
            LinkedListNode newNodo = head;
            while (node.next() != null && node.next() != node)
            {
                node = node.next();
            }
            return (T) node.getObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public T getNext(Node node)//20
    {
        try
        {
            if (head != null)
            {
                return (T) head.getObject();
            }
            else
            {
                return null;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public T getFirst()//21
    {
        try
        {
            if (head == null)
            {
                return null;
            }
            return (T) head.getObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public T[] getFirst(int n)//22
    {
        try
        {
            if (n <= 0)
            {
                return null;
            }
            Object[] objects = new Object[n];
            Node current = head;
            int index = 0;
            while (current != null && index < n)
            {
                objects[index] = current.getObject();
                current = current.next();
                index++;
            }
            return (T[]) objects;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public T getLast()//23
    {
        try
        {
            if (head == null)
            {
                return null;
            }
            Node current = head;
            while (current.next() != null)
            {
                current = current.next();
            }
            return (T) current.getObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public T[] getLast(int n)//24
    {
        try
        {
            if (n <= 0 || head == null)
            {
                return null;
            }
            Object[] objects = new Object[n];
            Node current = head;
            int count = 0;
            while (current.next() != null)
            {
                count++;
                if (count > n)
                {
                    objects[count % n] = current.getObject();
                }
                current = current.next();
            }
            if (count < n) {
                return (T[]) Arrays.copyOfRange(objects, n - count, n);
            }
            return (T[]) objects;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public T pop()//25
    {
        try
        {
            if (head == null)//Comprueba si esta vacia
            {
                return null;
            }
            LinkedListNode newNodo = head; //Nodo que recorre la lista
            LinkedListNode Previo = null; //Nodo anterior


            while (newNodo.next != null)//Recorre la lista
            {
                Previo = newNodo;
                newNodo = (LinkedListNode) newNodo.next();
            }
            if (Previo == null)
            {
                head = null;
            }
            else
            {
                Previo.next = null;
            }
            return (T) newNodo.getObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return null;
        }
    }

    @Override
    public boolean remove(T object)//26
    {
        try
        {
            LinkedListNode current = head;
            while (current != null)//recorre la lista
            {
                if (current.equals(object))// de encontrar el nodo con el objeto lo vuelve nulo
                {
                    current.setObject(null);
                    return true;
                }
                current = (LinkedListNode) current.next;
            }
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return false;
        }
    }

    @Override
    public boolean remove(Node node)//27
    {
        try
        {
            if (head == null || node == null)
            {
                return false;
            }
            if (head == node)
            {
                head = (LinkedListNode) head.next;
                return true;
            }
            Node current = head;
            while (current.next() != null && current.next() != node)
            {
                current = current.next();
            }
            if (current.next() == null)
            {
                return false;
            }
            current.next().setObject((Node) current.next().next().getObject());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return false;
        }
    }

    @Override
    public boolean removeAll(T[] objects)//28
    {
        try
        {
            LinkedListNode current = head;
            while (current != null)
            {
                for(int i = 0; i<objects.length;i++ )//recorre la lista
                {
                    Object newObject;
                    newObject = objects[i];
                    if (current.equals(newObject))
                    {
                        current.setObject(null);
                        return true;
                    }
                }
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return false;
        }
    }

    @Override
    public boolean retainAll(T[] objects)//29
    {
        try
        {

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return false;
        }
    }

    @Override
    public boolean set(Node node, T object)//30
    {
        try
        {
            node.setObject(object);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return false;
        }
    }

    @Override
    public int size()//31
    {
        try
        {

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return 0;
        }
    }

    @Override
    public List subList(Node from, Node to)//32
    {
        return null;
    }

    @Override
    public T[] toArray()//33
    {
        return null;
    }

    @Override
    public boolean orderBy(char c)//34
    {
        return false;
    }

    @Override
    public void print()//35
    {

    }

    @Override
    public Iterator<Node> iterator()//36
    {
        return null;
    }
}
