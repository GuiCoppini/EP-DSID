import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements Hello {

    public HelloServer() throws RemoteException {
        super();
    }

    @Override
    public String helloString(String str) throws RemoteException {
        return "Voce enviou a string ["+str+"]";
    }

    @Override
    public Integer helloInteger(Integer number) throws RemoteException {
        return 10 * number;
    }

    @Override
    public Long helloLong(Long number) throws RemoteException {
        return 10L * number;
    }

    @Override
    public Long hello8Longs(Long number1, Long number2, Long number3, Long number4, Long number5, Long number6, Long number7, Long number8) throws RemoteException {
        return number1+number2+number3+number4+number5+number6+number7+number8;
    }

//    @Override
//    public void voidFunction() {
//        int a = 10;
//        int b = 30;
//        int c = a + b;
//    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            String bindLocation = "//0.0.0.0:1099/server";
            Naming.bind(bindLocation, new HelloServer());
//            registry.rebind("server", new HelloServer());
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