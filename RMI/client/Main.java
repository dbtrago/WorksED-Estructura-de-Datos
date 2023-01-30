package client;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        Client client = new Client("10.150.78.52", "1804", "service");
        try {
            System.out.println(client.fn(20));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        System.out.println("RMI Client");
    }
}