import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service extends UnicastRemoteObject implements RMI
{
    private static final long serialVersionUID = 1L;
    //Creación de los clientes
    server.Cliente cliente1 = new server.Cliente("Santiago", "1725", 50000);
    server.Cliente clienteActual;
    server.Cliente clientesRegistrados[] = {cliente1};
    public Service() throws RemoteException
    {
    }

    @Override
    public int fn(int a) throws RemoteException
    {
        return a + 150;
    }
    //Metodos
    @Override
    public boolean login(String nameUser, String password) throws RemoteException
    {
        for (int i = 0; i < clientesRegistrados.length; i++)
        {
            if (clientesRegistrados[i].getUsuario().equals(nameUser))
            {
                if (clientesRegistrados[i].getContraseña().equals(password))
                {
                    clienteActual = clientesRegistrados[i];
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean retDinero(int salidaDinero) throws RemoteException
    {
        if(salidaDinero > clienteActual.getMontoDisponible())
        {
            System.out.println("No hay dinero suficiente para retirar esa cantidad. ");
            return false;
        }
        else
        {
            System.out.println("Sacando: " + salidaDinero);
            clienteActual.setMontoDisponible((clienteActual.getMontoDisponible()-salidaDinero));
            return true;

        }
    }

    @Override
    public boolean ingDinero(int entradaDinero) throws RemoteException
    {
        if(entradaDinero < 0)
        {
            System.out.println("Dinero no permitido. ");
            return false;
        }
        else
        {
            System.out.println("Ingresando " + entradaDinero);
            clienteActual.setMontoDisponible((clienteActual.getMontoDisponible()+entradaDinero));
            return true;
        }
    }

    @Override
    public int consultDinero() throws RemoteException
    {
        return clienteActual.getMontoDisponible();
    }

}
