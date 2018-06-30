import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    static String message = "blank";
// The Hello object "obj" is the identifier that is 

    // the Hello interface.
    static Hello obj = null;

    public static void main(String args[]) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            Hello stub = (Hello) registry.lookup("HelloServer");

            String response = stub.helloString();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}