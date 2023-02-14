import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote
{
    public int fn(int a) throws RemoteException;
    public boolean login(String nameUser, String password) throws  RemoteException;

    public boolean retDinero(int salidaDinero) throws  RemoteException;

    public boolean ingDinero(int entradaDinero) throws  RemoteException;

    public int consultDinero() throws  RemoteException;
}
