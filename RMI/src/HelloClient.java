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

            Integer intResponse = stub.helloInteger(10);
            String strResponse = stub.helloString("SHAZAM"); // mudar tamanho da string
            Long longResponse = stub.helloLong(15L);
            Long eightLongsResponse = stub.hello8Longs(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);

            stub.voidFunction();


            System.out.println("Integer: " + intResponse);
            System.out.println("String: " + strResponse);
            System.out.println("Long: " + longResponse);
            System.out.println("8 Longs: " + eightLongsResponse);
        } catch(Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}