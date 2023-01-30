package server;

import interfaces.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service extends UnicastRemoteObject implements RMI {

    private static final long serialVersionUID = 1L;
    public Service() throws RemoteException {
    }

    @Override
    public int fn(int a) throws RemoteException {
        return a + 15;
    }

}
