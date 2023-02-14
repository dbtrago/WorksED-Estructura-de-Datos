package server;

public class Main
{
    public static void main(String[] args)
    {
        Server server = new Server("localhost", "1804", "service");
        server.deployService();
        System.out.print("Service on");
    }
}