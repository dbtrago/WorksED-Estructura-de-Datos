import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main
{
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
    }
}
