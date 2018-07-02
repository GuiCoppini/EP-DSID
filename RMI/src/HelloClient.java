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

            String response = stub.helloString();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}