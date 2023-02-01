package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
    public int fn(int a) throws RemoteException;

}
