package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Properties;

public class Main
{
    public static void main(String[] args)
    {
        //Server
        Properties properties= new Properties();
        try
        {
            String a = ipHost();
            properties.load(new FileInputStream(new File("server.properties")));
            Server server = new Server(
                    (String) a,
                    (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME")
            );
            server.deployService();
            System.out.print("Service on");
        }
         catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
        //metodos
        public static String ipHost()
        {
            try
            {
                Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                String ipHost = null;
                while (interfaces.hasMoreElements()) 
                {
                    NetworkInterface interfaz = interfaces.nextElement();
                    if (interfaz.isLoopback() || !interfaz.isUp())
                    {
                        continue;
                    }

                    Enumeration<InetAddress> direcciones = interfaz.getInetAddresses();
                    while (direcciones.hasMoreElements()) 
                    {
                        InetAddress direccion = direcciones.nextElement();
                        if (direccion.isLinkLocalAddress() || direccion.isLoopbackAddress() || direccion.isMulticastAddress())
                        {
                            continue;
                        }
                        ipHost = direccion.getHostAddress();
                        System.out.println("La dirección IP de la red es: " + ipHost);
                        return ipHost();
                    }
                }
            } 
            catch (SocketException e)
            {
                System.out.println("No se pudo obtener la dirección IP de la red.");
                e.printStackTrace();
            }
            return ipHost();
        }
    
}