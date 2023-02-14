import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

public class Main
{
    public static void main(String[] args) throws RemoteException
    {
        Properties properties= new Properties();
        try
        {
            properties.load(new FileInputStream(new File("client.properties")));
            Client client = new Client(
                    (String) properties.get("IP"),
                    (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME")
            );
            System.out.println(client.fn(200));
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        //Creación
        Client client = new Client("localhost", "1804", "service");
        try
        {
            if(client.login("Santiago", "1725")){
                System.out.println(client.retDinero(20000));
                System.out.println(client.ingDinero(1000));
                System.out.println(client.consultDinero());

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
        System.out.println("RMI Client");
    }
}