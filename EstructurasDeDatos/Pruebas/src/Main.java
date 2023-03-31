import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Main
{
    /* 
    public static void main(String[] args)
    {
        try
        {
            InetAddress direccion = InetAddress.getLocalHost();
            System.out.println("La dirección IP de la máquina es: " + direccion.getHostAddress());
        }
        catch (UnknownHostException e)
        {
            System.out.println("No se pudo obtener la dirección IP de la máquina.");
            e.printStackTrace();
        }
    */
    public static void main(String[] args)
    {
        try
        {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) 
            {
                NetworkInterface interfaz = interfaces.nextElement();
                if (interfaz.isLoopback() || !interfaz.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> direcciones = interfaz.getInetAddresses();
                while (direcciones.hasMoreElements()) {
                    InetAddress direccion = direcciones.nextElement();
                    if (direccion.isLinkLocalAddress() || direccion.isLoopbackAddress() || direccion.isMulticastAddress()) {
                        continue;
                    }
                    System.out.println("La dirección IP de la red es: " + direccion.getHostAddress());
                }
            }
        } 
        catch (SocketException e)
        {
            System.out.println("No se pudo obtener la dirección IP de la red.");
            e.printStackTrace();
        }
    }
}
