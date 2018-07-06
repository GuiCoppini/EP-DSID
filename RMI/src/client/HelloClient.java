package client;

import interfaces.Hello;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    // the Hello interface.
    static Hello obj = null;

    public static void main(String args[]) {
        //        String host = (args.length < 1) ? null : args[0];

        try {
            long start = System.currentTimeMillis();

            System.out.println("Iniciando conexão com o Servidor");
            String host = "189.33.183.167";
            int port = 1099;


            Registry registry = LocateRegistry.getRegistry(host, port);
            System.out.println("Conexão feita ao HOST "+host + ":" + port);

            System.out.println("Criando stub");
            Hello stub = (Hello) registry.lookup("server");
            System.out.println("Stub criado!");

            Integer intResponse = stub.helloInteger(10);
//            String strResponse = stub.helloString("SHAZAM"); // mudar tamanho da string
//            Long longResponse = stub.helloLong(15L);
//            Long eightLongsResponse = stub.hello8Longs(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
//            stub.voidFunction();

            long totalTime = System.currentTimeMillis() - start;
            System.out.println("Tempo discorrido: " + totalTime + "ms");


//            System.out.println("Integer: " + intResponse);
//            System.out.println("String: " + strResponse);
//            System.out.println("Long: " + longResponse);
//            System.out.println("8 Longs: " + eightLongsResponse);
        } catch(Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}