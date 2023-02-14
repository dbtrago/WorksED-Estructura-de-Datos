import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    private RMI service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public Client(String ip, String port, String serviceName)
    {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }
    //Ejemplo
    public int fn(int test) throws RemoteException
    {
        try
        {
            service = (RMI) Naming.lookup(url);
            return service.fn(test);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean login(String nameUser, String password) throws RemoteException
    {
        try
        {
            service = (RMI) Naming.lookup(url);
            return service.login(nameUser, password);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean retDinero(int salidaDinero) throws RemoteException
    {
        try
        {
            service = (RMI) Naming.lookup(url);
            return service.retDinero(salidaDinero);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ingDinero(int entradaDinero) throws RemoteException
    {
        try
        {
            service = (RMI) Naming.lookup(url);
            return service.ingDinero(entradaDinero);
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public int consultDinero() throws RemoteException
    {
        try
        {
            service = (RMI) Naming.lookup(url);
            return service.consultDinero();
        }
        catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
