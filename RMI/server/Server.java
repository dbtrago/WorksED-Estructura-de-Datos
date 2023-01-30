package server;

import interfaces.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public String ip;
    public String port;
    public String serviceName;
    public String url;

    public Server(String ip, String port, String serviceName) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "//" + ip + ":" + port + "/" + serviceName;
    }

    public boolean deployService() {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null) return ack;
        try {
            System.setProperty( "java.rmi.server.hostname", ip); //para levantar un servidor
            RMI service = new Service(); // Instancia de un servicio el codigo esta en server
            LocateRegistry.createRegistry(Integer.parseInt(port)); // Se registrara en el puerto asociada a la conexión
            //que hemos armado
            Naming.rebind(url, service); // se construye la cadena de coneción con la que se publica el servicio
            //Usado en intra net
            ack = true;
        } catch (RemoteException e)
        {
            e.printStackTrace();
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return ack;
        }
    }

}
