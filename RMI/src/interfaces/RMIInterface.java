package interfaces;
import classescomplexas.Pessoa;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIInterface extends Remote {
    String sendString(String str) throws RemoteException;

    Integer sendInteger(Integer number) throws RemoteException;

    Long sendLong(Long number) throws RemoteException;

    Long send8Longs(Long number1, Long number2, Long number3, Long number4, Long number5, Long number6, Long number7, Long number8) throws RemoteException;

    void voidFunction() throws RemoteException;

    String oiDaPessoa(Pessoa pessoa) throws RemoteException;

    Double sendDouble(Double number) throws RemoteException;

    Pessoa sendListaPessoa(List<Pessoa> lista) throws RemoteException;
}
