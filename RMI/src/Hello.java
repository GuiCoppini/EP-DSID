import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String helloString() throws RemoteException;

    Integer helloInteger() throws RemoteException;

    Long helloLong() throws RemoteException;
}
