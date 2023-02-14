package client;

import interfaces.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client
{
    private RMI service;
    private String ip;
    private String port;
    private String serviceName;
    private String url;

    public Client(String ip, String port, String serviceName)//Constructor
    {
        this.service = null;
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "rmi://" + ip + ":" + port + "/" + serviceName;
    }

    public int fn(int test) throws RemoteException //Ejemplo fn
    {

        try{
            service = (RMI) Naming.lookup(url);
            return service.fn(test);
        } catch (MalformedURLException | RemoteException | NotBoundException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean iniciarSesion(String nombreUsuario, String contraseña) throws RemoteException
    {

        try{
            service = (RMI) Naming.lookup(url);
            return service.iniciarSesion(nombreUsuario, contraseña);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean retirarDinero(int dineroSacar) throws RemoteException {

        try{
            service = (RMI) Naming.lookup(url);
            return service.retirarDinero(dineroSacar);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ingresarDinero(int dineroIngresar) throws RemoteException {

        try{
            service = (RMI) Naming.lookup(url);
            return service.ingresarDinero(dineroIngresar);
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int consultarDinero() throws RemoteException {

        try{
            service = (RMI) Naming.lookup(url);
            return service.consultarDinero();
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
