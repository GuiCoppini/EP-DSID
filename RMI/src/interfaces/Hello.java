package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String helloString(String str) throws RemoteException;

    Integer helloInteger(Integer number) throws RemoteException;

    Long helloLong(Long number) throws RemoteException;

    Long hello8Longs(Long number1, Long number2, Long number3, Long number4, Long number5, Long number6, Long number7, Long number8) throws RemoteException;

    void voidFunction() throws RemoteException;
}
