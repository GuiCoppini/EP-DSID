package client;


import interfaces.Hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {

    public static void main(String args[]) {
        try {
            // Começa a contar o tempo
            long start = System.currentTimeMillis();

            // Aqui vem o IP do Host do servidor
            String host = "192.168.1.105";

            // Porta na qual o host vai deixar o server 'escutando'
            int port = 1099;


            // Faz conexao com o HOST na porta indicada
            Registry registry = LocateRegistry.getRegistry(host, port);

            // Busca pelo server que esta bindado neste caminho 'server' dentro do host
            // e cria o stub
            Hello stub = (Hello) registry.lookup("server");


            // Todos os métodos usados para testar
            // O programa foi rodado cerca de 10 vezes para cada um dos testes individualmente


//            Integer intResponse = stub.helloInteger(10);
//            Long longResponse = stub.helloLong(10L);
//            int stringSize = 2048;
//            String strResponse = stub.helloString(createString(stringSize)); // mudar tamanho da string
//            Long eightLongsResponse = stub.hello8Longs(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
//            stub.voidFunction();


            // Termina calculo do tempo
            long totalTime = System.currentTimeMillis() - start;

            System.out.println("Tempo discorrido: " + totalTime);
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
        }
    }

    // Metodo auxiliar para criar Strings grandes/pequenas de acordo com a necessidade para testar o string
    private static String createString(int size) {
        String result = "";
        for(int i = 0; i<size; i++){
            result += ".";
        }
        return result;
    }
}