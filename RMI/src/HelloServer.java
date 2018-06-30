import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer implements Hello {

    public HelloServer() {}

    @Override
    public String helloString() throws RemoteException {
        return "Hello Amigao";
    }

    @Override
    public Integer helloInteger() throws RemoteException {
        return 1;
    }

    @Override
    public Long helloLong() throws RemoteException {
        return 1L;
    }

    public static void main(String args[]) {

        try {
            HelloServer obj = new HelloServer();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("HelloServer", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }
}