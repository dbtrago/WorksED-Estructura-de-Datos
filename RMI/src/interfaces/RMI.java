package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote
{
    public int fn(int a) throws RemoteException;

    public boolean iniciarSesion(String nombreUsuario, String contraseña) throws  RemoteException;

    public boolean retirarDinero(int dineroSacar) throws  RemoteException;

    public boolean ingresarDinero(int dineroIngresar) throws  RemoteException;

    public int consultarDinero() throws  RemoteException;

}
