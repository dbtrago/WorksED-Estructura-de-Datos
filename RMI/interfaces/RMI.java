package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
//Podemos cambiar el nombre de la interfaz, a interfaz, servidor, etc...
public interface RMI extends Remote
{
    //Todos los metodos estan en el servidor
    public int fn(int a) throws RemoteException;
    //Los metodos de aquí para abajo estan a la mano de lo que necesitemos
}
