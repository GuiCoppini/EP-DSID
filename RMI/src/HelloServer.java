import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements Hello {

    public HelloServer() throws RemoteException {
        super();
    }

    @Override
    public String helloString() throws RemoteException {
        return "Hello Amigao";
    }

    @Override
    public Integer helloInteger() throws RemoteException {
        return 10 * 10;
    }

    @Override
    public Long helloLong() throws RemoteException {
        return 10L * 10L;
    }


    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("server", new HelloServer());
            System.out.println("Server started!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main2(String args[]) {
//        Hello obj = new HelloImpl();
//
//        try {
//            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
//
//            // Bind the remote object's stub in the registry
//            Registry registry = LocateRegistry.getRegistry();
//            registry.bind("HelloServer", stub);
//
//            System.err.println("Server ready");
//
//        } catch (Exception e) {
//            System.err.println("Server exception: " + e.toString());
//            e.printStackTrace();
//            System.exit(0);
//        }
//    }
}