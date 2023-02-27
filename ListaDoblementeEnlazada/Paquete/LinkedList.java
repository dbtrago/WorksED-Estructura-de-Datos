package Paquete;

import interfaces.List;
import interfaces.Node;

import java.io.OptionalDataException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Comparator;

public class LinkedList<T> implements List<T>
{
    public LinkedListNode head; //Es una referencia, una dirección de memoria
    public LinkedListNode tail;
    public LinkedListNode iterador;
    public LinkedList()
    { //permite iniciar una lista sin que tenga ningun nodo
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) //Main de pruebas
    {

    }
    /***
     * 1. Agrega un objeto al final de la lista.
     * @param object objeto
     * @return boolean true
     */
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
                	LinkedListNode newNode = new LinkedListNode(object); //Se crea un nodo con el objeto
                	newNode.prev = tail; // Se agrega la información del anterior nodo que sería la cola
                    tail.next = newNode; // se le asigna a la anterior cola             
                    tail = newNode; // se determibna que el agregado es la nueva cola
                }
                System.out.println("Se agrego un nodo");
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
    /***
     * 2. Inserta un objeto en una posición siguiente al nodo especificado.
     * @param node nodo
     * @param object objeto
     * @return boolean true
     */
    @Override
    public boolean add(Node node, T object)
	{
        try
        {
        	if(object != null)
        	{
	            LinkedListNode nodoReference = (LinkedListNode)node; // castea un linkedlistnode ingresando la referencia del nodo que entra
	            if(isEmpty())
	            {
	                head = nodoReference; // se asigna el nodo nuevo que entro
	                nodoReference.next = new LinkedListNode(object);//Se castea por que no se puede obtener un objeto
	
	            }
	            if(nodoReference == tail)// Si es el mismo nodo que la cola se agrega siguiente a la misma
	            {
	            	LinkedListNode newNode = new LinkedListNode(object);
	            	newNode.prev = tail;
	                tail.next = newNode;
	                tail = newNode;
	            }
	            else
	            {
	                LinkedListNode nodoSiguiente = new LinkedListNode(object);
	                nodoReference.next = nodoSiguiente;
	            }
	            System.out.println("Se agrego");
	            return true;
        	}        	
        }
        catch (Exception e)// En caso de errores
        {
            e.printStackTrace();
        }
        finally
        {
            return false;//no se probado
        }
	}
    /***
     * 3. Inserta un nodo en una posición siguiente al nodo especificado.
     * @param node node
     * @param next node
     * @return boolean true
     */
    public boolean add(Node node, Node next)// 3
    {
        boolean ack = false;
        try
        {
            if (node == null && next == null)//retorna falso si ambos nodos ingresados no contienen información
            {
                return false;
            }
            LinkedListNode nodeEspecific = (LinkedListNode)next;
            LinkedListNode nodeInsert = (LinkedListNode)node;            
            nodeInsert.prev = nodeEspecific;
            if(nodeEspecific.next != null)
            {
            	nodeEspecific.next.prev = nodeInsert;
            	nodeInsert.next = nodeEspecific.next;
            }            
            nodeEspecific.next = nodeInsert;
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
    /***
     * 4. Agrega todos los objetos de un array al final de la lista.
     * @param objects objetos
     * @return boolean true
     */
    public boolean add(T[] objects)// 4
    {
        try
        {
            if (objects != null)
            {
                if (isEmpty())
                {
                    this.head = tail = new LinkedListNode(objects, head, null);
                    for(int i =  0; i < objects.length; i++)
                    {
                    	if(i == 0)
                    	{
                    		this.head = tail = new LinkedListNode (objects[i]);
                    		System.out.println("Se agrego un objeto");
                    	}
                    	if (i>0)
                    	{
                    		add(objects[i]);
                    		System.out.println("Se agrego un objeto");
                    	}
                    }
                }
                else
                {
                	for(int i =  0; i < objects.length; i++)
                    {
                		add(objects[i]);
                		System.out.println("Se agrego un objeto");
                    }
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
        	return false;
        }
    }

    /***
     * 5. Inserta todos los objetos de un array desde el nodo especificado.
     * @param node nodo
     * @param objects objetos
     * @return boolean true
     */
    public boolean add(LinkedListNode node, T[] objects)//5
    {
    	try
    	{
	    	if (node == null || objects == null || objects.length == 0)
	    	{
	            return false; // No se puede agregar si el nodo es nulo o el arreglo está vacío
	        }
	
	        LinkedListNode current  = (LinkedListNode)node;
	        for (T obj : objects)
	        {
	        	LinkedListNode newNode = new LinkedListNode(obj); // Crear un nuevo nodo para el objeto
	            newNode.prev = current; // Asignar el nodo actual como anterior al nuevo nodo
	            newNode.next = current.next; // Asignar el siguiente del nodo actual como siguiente del nuevo nodo
	            if (current.next() != null)
	            {
	                current.next.prev = newNode; // Asignar el nuevo nodo como anterior del nodo siguiente al actual
	            }
	            current.next = newNode; // Asignar el nuevo nodo como siguiente del nodo actual
	            current = newNode; // Avanzar el puntero actual al nuevo nodo
	        }
	
	        return true; // Se insertaron todos los objetos
    	}
    	catch (Exception e)
    	{
    		System.out.println("Fallo");
    		return false;
    	}
    }
    /***
     * 6. Inserta el objeto especificado al inicio de la lista.
     * @param object objecto
     * @return boolean true
     */
    public boolean addFirst(T object)//6
    {
    	try
    	{
    		LinkedListNode newNode = new LinkedListNode(object);
    	    if (head == null)
    	    {
    	        head = newNode;
    	        tail = newNode;
    	    }
    	    else
    	    {
    	        newNode.next = head;
    	        head.prev = newNode;
    	        head = newNode;
    	    }
    	    return true;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    }
    /***
     * 7. Agrega todos los objetos de un array al inicio de la lista.
     * @param objects objetos
     * @return boolean true
     */
    public boolean addFirst(T[] objects)//7
    {
    	try
    	{
	    	// Si la lista está vacía, se agregan los objetos en orden inverso
	        if (head == null)
	        {
	            for (int i = objects.length - 1; i >= 0; i--)
	            {
	                LinkedListNode node = new LinkedListNode(objects[i]);
	                head = tail = node;
	            }
	        }
	        // Si la lista no está vacía, se agregan los objetos al inicio de la lista
	        else {
	            for (int i = objects.length - 1; i >= 0; i--)
	            {
	            	LinkedListNode  node = new LinkedListNode (objects[i]);
	                node.next = head;
	                head.prev = node;
	                head = node;
	            }
	        }
	        return true;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    }
    /***
     * 8. Inserta el objeto especificado al final de la lista.
     * @param object objeto
     * @return boolean true
     */
    public boolean addLast(T object)//8
    {
		try
		{
			LinkedListNode newNode = new LinkedListNode(object);
		    if (tail == null)
		    {
		        head = tail = newNode;
		    }
		    else
		    {
		        newNode.prev = tail;
		        tail.next = newNode;
		        tail = newNode;
		    }
		    return true;
		}
		catch(Exception e)
		{
			return false;
		}

    }

    /***
     * 9. Agrega todos los objetos de un array al final de la lista.
     * @param objects objetos
     * @return boolean true
     */
    public boolean addLast(T[] objects)//9
    {
    	try
    	{
	    	if (objects == null || objects.length == 0)
	    	{
	            return false;
	        }
	        for (T obj : objects)
	        {
	            addLast(obj);
	        }
	        return true;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    }
    /***
     * 10. Elimina todos los elementos de la lista.
     * @return boolean true
     */
    public boolean clear()//10
    {
    	try
    	{
	    	if (isEmpty())
	    	{ // Si la lista está vacía
	            return false;
	        }
	    	LinkedListNode currentNode = head;
	        while (currentNode != null)
	        { // Recorremos la lista
	        	LinkedListNode nextNode = currentNode.next; // Obtenemos el siguiente nodo
	            currentNode.setObject(null); // Liberamos el objeto que contiene el nodo actual
	            currentNode.next = null; // Desconectamos el nodo actual del siguiente nodo
	            currentNode.prev = null; // Desconectamos el nodo actual del nodo anterior
	            currentNode = nextNode; // Avanzamos al siguiente nodo
	        }
	        head = tail = null; // Establecemos la cabeza y la cola en nulo	        
	        return true;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    }
    /***
     * 11. Retorna una instacia nueva de la lista.
     * @return List
     */
    @Override
    public List clone()//11
    {
    	try
    	{
	    	LinkedList newList = new LinkedList<T>();
	    	LinkedListNode currentNode = head;
	        while (currentNode != null)
	        {
	            newList.addLast(currentNode.getObject());
	            currentNode = currentNode.next;
	        }
	        return newList;
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
    /***
     * 12. Retorna verdadero si contiene el objeto.
     * @param object objecto
     * @return boolean true
     */
    @Override
    public boolean contains(T object)//12
    {
    	try
    	{
	    	LinkedListNode currentNode = head;
	        while (currentNode != null)
	        {
	            if (currentNode.getObject().equals(object))
	            {
	                return true;
	            }
	            currentNode = currentNode.next;
	        }
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
        return false;
    }
    /***
     * 13. Retorna verdadero si contiene todos los objetos.
     * @param objects objectos
     * @return boolean true
     */
    @Override
    public boolean contains(T[] objects)//13
    {
    	try
    	{
	    	for (T obj : objects)
	    	{
	            boolean found = false;
	            LinkedListNode currentNode = head;
	            while (currentNode != null)
	            {
	                if (currentNode.getObject().equals(obj))
	                {
	                    found = true;
	                    break;
	                }
	                currentNode = currentNode.next;
	            }
	            if (!found)
	            {
	                return false;
	            }
	        }
	        return true;
        }
    	catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    /***
     * 15. Retorna el nodo del objeto especificado, o null si no contiene el objeto.
     * @param object objeto
     * @return node nodo
     */
    @Override
    public Node nodeOf(T object)//15 Retorna el nodo del objeto especificado, o null si no contiene el objeto
    {
        try
        {
        	LinkedListNode currentNode = head;
            while (currentNode != null)
            {
                if (currentNode.getObject().equals(object))
                {
                    return currentNode;
                }
                currentNode = currentNode.next;
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
    /***
     * 16. Retorna verdadero si no contiene elementos.
     * @return boolean true
     */
    public boolean isEmpty()//16 verifica si el nodo esta vacio
    {
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
            return false;
        }
    }
    /***
     * 17. Retorna el objeto del último nodo insertado.
     * @return Object objeto
     */
    public T get()//17 Retorna el objeto del último nodo insertado.
    {
        try
        {
        	LinkedListNode last = tail;
        	if (last == null)
        	{
                return null;
            }
        	else
            {
                return (T) last.getObject();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            return null;
        }
    }

    /***
     * 18. Retorna un objeto de la posición del nodo especificado.
     * @param node nodo
     * @return Object objeto
     */
    @Override
    public T get(Node node)//18 Retorna un objeto de la posición del nodo especificado
    {        
        try
        {
            LinkedListNode nodoReferente = (LinkedListNode)node;
            if(nodoReferente.getObject() != null)
            {
            	return (T) nodoReferente.getObject();
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
    /***
     * 19. Retorna un objeto de la posición previa al nodo especificado.
     * @param node nodo
     * @return Object objeto
     */
    @Override
    public T getPrevious(Node node)//19
    {
        try
        {
        	LinkedListNode nodeReference = (LinkedListNode)node;
        	if (nodeReference == null || nodeReference.prev == null)
        	{
                return null;
            }
            return (T) nodeReference.prev.getObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            return null;
        }
    }
    /***
     * 20. Retorna un objeto de la posición siguinete al nodo especificado.
     * @param node nodo
     * @return Object objeto
     */
    @Override
    public T getNext(Node node)//20
    {
        try
        {
        	LinkedListNode nodeReference = (LinkedListNode)node;
        	if (nodeReference == null || nodeReference.next == null)
        	{
                return null;
            }
            return (T) nodeReference.next.getObject();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            return null;
        }
    }
    /***
     * 21. Retorna el objeto al inicio de esta lista.
     * @return Object objeto
     */
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
    /***
     * 22. Retorna un array de n objetos desde inicio de esta lista.
     * @return Object objetos
     */
    @Override
    public T[] getFirst(int n)//22
    {
        try
        {
        	if (n < 0 || head == null)
        	{
                return null;
            }
            T[] result = (T[]) new Object[n];
            LinkedListNode node = head;
            for (int i = 0; i < n && node != null; i++)
            {
                result[i] = (T) node.getObject();
                node = node.next;
            }
            return result;
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
    
    /***
     * 23. Retorna el objeto al final de esta lista.
     * @return Object objeto
     */
    @Override
    public T getLast()//23
    {
        try
        {
        	if (isEmpty()) {
                return null;
            } else {
                LinkedListNode current = tail;
                return (T) current.getObject();
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
    /***
     * 24. Retorna un array de n objetos previos al final de esta lista.
     * @return Object objetos
     */
    @Override
    public T[] getLast(int n)//24
    {
        try
        {
        	if (isEmpty() || n <= 0)
        	{
                return null;
            }
        	else
            {
                LinkedListNode current = tail;
                T[] result = (T[]) new Object[n];
                int i = 0;
                while (current.prev != null && i < n)
                {
                    result[i++] = (T) current.getObject();
                    current = (LinkedListNode) current.prev();
                }
                return result;
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
    /***
     * 25. Retorna el objeto al final de esta lista y lo elimina.
     * @return Object objeto
     */
    @Override
    public T pop()//25
    {
        try
        {
        	if (isEmpty())
        	{
                return null;
            }
        	else
            {
                LinkedListNode lastNode = new LinkedListNode(tail.getObject());
                tail = tail.prev;
                tail.next = null;                
                return (T) lastNode.getObject();
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
    
    /***
     * 26. Elimina el nodo en la lista.
     * @param object objeto
     * @return true
     */
    @Override
    public boolean remove(T object)//26
    {
        try
        {
        	if (isEmpty())
        	{
                return false;
            }
        	else
            {
                LinkedListNode current = head;
                while (current != null)
                {
                    if (current.getObject().equals(object))
                    {
                        if (current == head)
                        {
                            head = current.next;
                            if (head != null) {
                                head.prev = null;
                            }
                        }
                        else if (current == tail)
                        {
                            tail = current.prev;
                            if (tail != null) {
                                tail.next = null;
                            }
                        } else {
                            current.prev.next = (current.next);
                            current.next.prev = (current.prev);
                        }
                        return true;
                    }
                    current = current.next;
                }
                return false;
            }
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
    /***
     * 27. Elimina el nodo en la lista.
     * @param node nodo
     * @return true
     */
    @Override
    public boolean remove(Node node)
    {
    	try
    	{
    		LinkedListNode nodo  = (LinkedListNode)node;
	        if (nodo == null || isEmpty())
	        {
	            return false;
	        }
	        if (nodo == head)
	        {
	            head = nodo.next;
	        }
	        else if (node == tail)
	        {
	            tail = nodo.prev;
	        }
	        else
	        {
	            nodo.prev.next = nodo.next;
	            nodo.next.prev = nodo.prev;
	        }
	        return true;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    } 
    
    /***
     * 28. Elimina de esta lista todos los nodos de los objetos que están contenidos en la colección especificada.
     * @param  objects objetos
     * @return true
     */

    @Override
    public boolean removeAll(T[] objects)//28
    {
    	
		try
		{
			if(objects!=null)
			{   
				for (int i = 0; i < objects.length; i++)
				{
					remove(objects[i]);// se usa el metodo de remover objeto
				}
				return true;	
			}
        }catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return false;
		}
    }
    /***
     * 29. Conserva solo los objetos del array.
     * @param objects objetos
     * @return boolean true
     */
    @Override
    public boolean retainAll(T[] objects)//29
    {
        try
        {
        	 boolean removed = false;
        	    LinkedListNode current = head;
        	    while (current != null)
        	    {
        	        boolean contains = false;
        	        for (T obj : objects)
        	        {
        	            if (current.getObject().equals(obj))
        	            {
        	                contains = true;
        	                break;
        	            }
        	        }
        	        if (!contains)
        	        {
        	            if (current == head)
        	            {
        	                head = current.next;
        	                if (head != null)
        	                {
        	                    head.prev = null;
        	                }
        	            }
        	            else if (current == tail)
        	            {
        	                tail = current.prev;
        	                if (tail != null) {
        	                    tail.next = null;
        	                }
        	            } else {
        	                current.prev.next = current.next;
        	                current.next.prev = current.prev;
        	            }
        	            removed = true;
        	        }
        	        current = current.next;
        	    }
        	    return removed;
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
    /***
     * 30. Reemplaza el objeto en la posición del nodo especificado.
     * @param node nodo
     * @param object object
     * @return true
     */
    @Override
    public boolean set(Node node, T object)//30
    {
        try
        {
        	if(object != null)
        	{
	        	LinkedListNode nodo = (LinkedListNode)node;
	        	if (node == null)
	        	{
	                return false;
	            }
	            nodo.setObject(object);
	            return true;
        	}
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
    /***
     * 31. Retorna el número de nodos de esta lista.
     * @return int amount
     */
    @Override
    public int size()//31
    {
        try
        {
        	int count = 0;
            LinkedListNode node = head;
            while (node != null)
            {
                count++;
                node = node.next;
            }
            return count;
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
    /***
     * 32. Retorna una sub lista de la lista.
     * @param from nodo
     * @param to nodo
     * @return List list
     */
    @Override
    public List subList(Node from, Node to)//32
    {
    	try
    	{
	    	LinkedList subList = new LinkedList();
	        LinkedListNode node = (LinkedListNode)from;
	        while (node != null && node != to)
	        {
	            subList.add(node.getObject());
	            node = node.next;
	        }
	        return subList;
    	}
    	catch (Exception e)
    	{
    		return null;
    	}
    }
    /***
     * 33. Retorna un array que contiene todos los elementos de esta lista.
     * @return array arreglo
     */
    @Override
    public T[] toArray()//33
    {
    	try
    	{
    		T[] arr = (T[]) new Object[size()];
    	    LinkedListNode node = head;
    	    int index = 0;
    	    while (node != null) {
    	        arr[index++] = (T) node.getObject();
    	        node = node.next;
    	    }
    	    return arr;
    	}
    	catch (Exception e)
    	{
    		return null;
    	}
    }
    /***
     * 34. Ordenar lista por un criterio.
     * @param c criterio
     * @return boolean list
     */
    @Override
    public boolean orderBy(char c)//34
    {
    	try
    	{
	    	boolean swapped;
	        LinkedListNode node1 = head;
	        LinkedListNode node2;
	        T temp;
	        if (head == null) {
	            return false;
	        }
	        do {
	            swapped = false;
	            node2 = node1.next;
	            while (node2 != null) {
	                if (c == 'a' ? ((String) node1.getObject()).compareTo((String) node2.getObject()) > 0 : ((String) node1.getObject()).compareTo((String) node2.getObject()) < 0) {
	                    temp = (T) node1.getObject();
	                    node1.setObject(node2.getObject());
	                    node2.setObject(temp);
	                    swapped = true;
	                }
	                node2 = node2.next;
	            }
	            node1 = node1.next;
	        }
	        while (swapped);
	        return true;
    	}
    	catch (Exception e)
    	{
    		return false;
    	}
    }

	    
    @Override
    public void print()//35
    {
    	try
    	{
       	   if(!isEmpty())
       	   {
       		 LinkedListNode nodoAux=head.next;
       		 System.out.print("LinkedList DobleEnlazada[ " );
       		 System.out.print("Head->" +head.getObject()+ " ----> ");       		 
       		 while(nodoAux!=null)
       		 {//para que solo se imprima una vuelta
       			   System.out.print("Prev->"+nodoAux.prev.getObject()+" ----> ");  
       			   System.out.print("Next->"+nodoAux.getObject()+" ----> ");
       			   nodoAux=nodoAux.next;
       		 }
       		 System.out.print("Tail-> " + tail.getObject()+ " ]");       		   
       	   }
    	}
    	catch (Exception e)
    	{
              e.printStackTrace();
          }
    }

    @Override
    public Iterator<Node> iterator()//36
    {
        return null;
    }

	@Override
	public boolean add(Node node, T[] objects) {
		// TODO Auto-generated method stub
		return false;
	}
}
