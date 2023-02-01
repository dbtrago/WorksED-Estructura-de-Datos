package server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server("10.150.78.52", "1804", "service");
        server.deployService();
        System.out.print("Service on");
    }
}