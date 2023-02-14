package server;

import interfaces.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service extends UnicastRemoteObject implements RMI {

    private static final long serialVersionUID = 1L;

    Cliente cliente1 = new Cliente("Nelson", "123", 50000);
    Cliente cliente2 = new Cliente("Yair", "123", 60000);
    Cliente cliente3 = new Cliente("Juan", "123", 70000);

    Cliente actualCliente;
    Cliente clientesRegistrados[] = {cliente1, cliente2, cliente3};

    public Service() throws RemoteException
    {
    }

    @Override
    public int fn(int a) throws RemoteException
    {
        return a + 15;
    }




    @Override
    public boolean iniciarSesion(String nombreUsuario, String contraseña) throws RemoteException {

        for (int i = 0; i < clientesRegistrados.length; i++) {

            if(clientesRegistrados[i].getUsuario().equals(nombreUsuario)){

                if(clientesRegistrados[i].getContraseña().equals(contraseña)){

                    actualCliente = clientesRegistrados[i];
                    return true;

                }


            }

        }

        return false;
    }

    @Override
    public boolean retirarDinero(int dineroSacar) throws RemoteException {

        if(dineroSacar > actualCliente.getMontoDisponible()){

            System.out.println("No hay monto suficiente. ");

            return false;

        }else{

            System.out.println("Retirando " + dineroSacar);
            actualCliente.setMontoDisponible((actualCliente.getMontoDisponible()-dineroSacar));
            return true;

        }

    }

    @Override
    public boolean ingresarDinero(int dineroIngresar) throws RemoteException {

        if(dineroIngresar < 0){

            System.out.println("Dinero no permitido. ");

            return false;

        }else{

            System.out.println("Ingresando " + dineroIngresar);
            actualCliente.setMontoDisponible((actualCliente.getMontoDisponible()+dineroIngresar));
            return true;

        }

    }

    @Override
    public int consultarDinero() throws RemoteException {
        return actualCliente.getMontoDisponible();
    }


}
