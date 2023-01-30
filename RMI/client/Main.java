package client;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        //Podemos usar local host para pruebas internas en maquinas virtuales
        //Solo si son  2 maquinas, mintras
        Client client = new Client("10.150.78.52", "1804", "service");
        //Se crea la URL
        try {
            System.out.println(client.fn(20));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        System.out.println("RMI Client");
    }
}