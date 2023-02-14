package client;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException
    {
        Client client = new Client("localhost", "1804", "service");
        try
        {
            if(client.iniciarSesion("Nelso", "123")){
                System.out.println(client.retirarDinero(20000));
                System.out.println(client.ingresarDinero(1000));
                System.out.println(client.consultarDinero());

            }
            else
            {
                System.out.println("Credenciales incorrectas. ");
            }
        }
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("RMI Client");
    }
}