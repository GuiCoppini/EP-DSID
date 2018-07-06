package server;


import classescomplexas.Pessoa;
import interfaces.RMIInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    public RMIServer() throws RemoteException {
        super();
    }

    @Override
    public String sendString(String str) throws RemoteException {
        return "Voce enviou a string ["+str+"]";
    }

    @Override
    public Integer sendInteger(Integer number) throws RemoteException {
        return 10 * number;
    }

    @Override
    public Long sendLong(Long number) throws RemoteException {
        return 10L * number;
    }

    @Override
    public Long send8Longs(Long number1, Long number2, Long number3, Long number4, Long number5, Long number6, Long number7, Long number8) throws RemoteException {
        return number1+number2+number3+number4+number5+number6+number7+number8;
    }

    @Override
    public void voidFunction() {
        // Apenas uma funcao para fazer coisas basicas e nao retornar nada
        int a = 10;
        int b = 30;
        int c = a + b;
    }

    @Override
    public String oiDaPessoa(Pessoa pessoa) throws RemoteException {
        String oiDaPessoa = pessoa.falaOi();
        System.out.println("Oi da pessoa: " + oiDaPessoa);
        return oiDaPessoa;
    }

    @Override
    public Double sendDouble(Double number) throws RemoteException {
        return number * 1.5;
    }

    @Override
    public Pessoa sendListaPessoa(List<Pessoa> lista) throws RemoteException {
        return lista.get(0);
    }

    public static void main(String[] args) {
        try {

            // Aqui vem o IP da rede do host (PC que está rodando essa classe)
            // Poderia ser substituído por rodar o server como
            // java server.helloServer -Djava.rmi.server.hostname=IP_LOCAL
            System.setProperty("java.rmi.server.hostname","localhost");

            // "Abre" o registro RMI na porta 1099 que é a default, mas poderíamos escolher outra
            Registry registry = LocateRegistry.createRegistry(1099);

            // Cria o Servidor que vai receber e cuidar das requests e binda ele no caminho '/server'
            // assim, quando o client bater no 'server', o RMIServer irá tratar
            RMIServer serverObject = new RMIServer();
            registry.rebind("server", serverObject);

            System.out.println("Server started!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}