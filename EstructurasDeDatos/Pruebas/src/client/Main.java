package client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException
    {
        Properties properties= new Properties();
        Scanner sc = new Scanner(System.in);
        int exit= 0; int otraVez=0;
        boolean login = false;

        try {
            properties.load(new FileInputStream(new File("client.properties")));
            Client client = new Client(
                    (String) properties.get("IP"),
                    (String) properties.get("PORT"),
                    (String) properties.get("SERVICENAME")
            );
            //Impresión del banco
            System.out.println("Banco"+"\n∵*.•´¸.•*´✶´♡"+"\n° ☆ ° ˛*˛☆_Π______˚☆"+"\n*˚ ˛★˛•*/________/ ~ ⧹。˚ ˚"+"\n˚ ˛•˛•˚  ｜ 田田 ｜門｜ ˚"+"\n╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬");
            //Entradas
            try
            {
                //Login
                while(login==false)
                {
                    System.out.println("Ingrese el usuario: ");
                    String user = sc.next().toString();//.toString(); funciona para convertir entradas de X cosa a String
                    System.out.println("Contraseña: ");
                    String password = sc.next().toString();

                    //client.registerUser(user,password,0)
                    if(client.login(user,password)) {
                        //Opciones
                        do {
                            System.out.println("Opciones \n1)Ingresar saldo\n2)Retirar saldo\n3)Consultar Saldo\nIngrese el número de la opción: ");
                            int option = sc.nextInt();
                            if (option == 1) {
                                System.out.println("Ingrese la cantidad a su cuenta: ");
                                int cantIng = sc.nextInt();

                                if (client.ingDinero(cantIng) == true) {
                                    System.out.println("Se ingreso la cantidad " + cantIng + " con exito!");
                                    //System.out.println("Su saldo es: " + client.consultDinero());

                                }
                                else{
                                    System.out.println("No se pudo ingresar " + cantIng);
                                }
                                login = true;

                            }
                            if (option == 2) {
                                System.out.println("Ingrese la cantidad a retirar: ");
                                int cantRet = sc.nextInt();
                                if (client.retDinero(cantRet) == true) {
                                    System.out.println("Se retiro la cantidad " + cantRet + " con exito!");
                                    //System.out.println("Su saldo es: " + client.consultDinero());
                                }
                                else{
                                    System.out.println("No se pudo retirar " + cantRet + " Intente otra cantidad \n o consulte su saldo");
                                }

                                login = true;
                            }
                            if (option == 3) {
                                System.out.println("Su saldo es: " + client.consultDinero());
                                login = true;
                            } else {
                                System.out.println();
                                login = true;
                            }

                            System.out.println("Quiere hacer mas transacciones? Digite 1");
                            otraVez=sc.nextInt();


                        }while (otraVez==1);
                    }
                }
            }
            catch(Exception e)
            {

            }

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("RMI Client");
    }
}