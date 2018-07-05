import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    // the Hello interface.
    static Hello obj = null;

    public static void main(String args[]) {
//        String host = (args.length < 1) ? null : args[0];

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

            Hello stub = (Hello) registry.lookup("server");

            Integer intResponse = stub.helloInteger();
            String strResponse = stub.helloString();
            Long longResponse = stub.helloLong();

            System.out.println("Integer: " + intResponse);
            System.out.println("String: " + strResponse);
            System.out.println("Long: " + longResponse);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}