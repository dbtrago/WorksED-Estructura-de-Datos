package server;

import interfaces.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Implementa RMI para la interfaz
public class Service extends UnicastRemoteObject implements RMI {
    //Para funcionar puede usar Unicast
    private static final long serialVersionUID = 1L; // esto es una bandera para saber cual es el objeto, 
    //compruebe y si no volverlo a pedir
    //Todos los objetps deben ser serialisables
    //para que se pueda convertir en un número.
    //No es serialisable si da error
    public Service() throws RemoteException {
    }

    //tendremos toda la logica necesaria, de lo que ser queira para hacer
    //Lo que se retorna ire por el cable hacia el cliente
    //Siempre tendran un Rmeote Exception
    @Override
    public int fn(int a) throws RemoteException
    {
        return a + 15;
    }

}
