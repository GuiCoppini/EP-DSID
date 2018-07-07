package client;


import classescomplexas.Pessoa;
import interfaces.RMIInterface;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RMIClient {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {


            // Aqui vem o IP do Host do servidor
            System.out.println("Insira o IP do servidor:");
            // Parece ser estranho, mas se eu nao fizesse essa passada de variavel,
            // estouraria uma IndexOutOfBounds: 0 para a string
            String host1 = sc.nextLine();
            String host = host1;

            // Porta na qual o host vai deixar o server 'escutando'
            System.out.println("Insira a porta na qual o servidor está aberto:");
            int port = sc.nextInt();


            // Começa a contar o tempo
            System.out.println("Tentando conectar com "+host+":"+port);
            long startStub = System.currentTimeMillis();
            // Faz conexao com o HOST na porta indicada
            Registry registry = LocateRegistry.getRegistry(host, port);

            // Busca pelo server que esta bindado neste caminho 'server' dentro do host
            // e cria o stub
            RMIInterface stub = (RMIInterface) registry.lookup("server");
            long timeStub = System.currentTimeMillis() - startStub;
            System.out.println("Conexão feita com servidor (e stub criado) em " + timeStub + "ms.");



            int opcao = 0;
            // Mostra o menu na tela, evita sujar codigo do main
            menuzinho(sc, stub, timeStub);


//            O programa foi rodado cerca de 10 vezes para cada um dos testes individualmente
//            Todos os métodos usados para testar

//            List<Pessoa> lista = new ArrayList<>();
//            lista.add(new Pessoa("Guilherme Coppini Pavani", 19, 1.73, 9862951));
//            lista.add(new Pessoa("Silvio Novaes de Lira Junior", 19, 1.74, 9778522));
//            lista.add(new Pessoa("Lucas Bordinhon Capalbo", 19, 1.78, 9877982));
//            Pessoa pessoaDaLista = stub.sendListaPessoa(lista);

//            String oiDaPessoa = stub.oiDaPessoa(new Pessoa("Guilherme", 19, 1.73, 9862951));
//            Integer intResponse = stub.sendInteger(10);
//            Long longResponse = stub.sendLong(10L);
//            String strResponse = stub.sendString(createString(stringSize)); // mudar tamanho da string
//            Long eightLongsResponse = stub.send8Longs(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
//            stub.voidFunction();
//            Double doubleResponse = stub.sendDouble(10.0);
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void menuzinho(Scanner sc, RMIInterface stub, long timeStub) throws RemoteException {
        int opcao;
        do {
            System.out.println("Que operação deseja fazer?");
            System.out.println("1) enviar integer");
            System.out.println("2) enviar long");
            System.out.println("3) enviar 8 longs");
            System.out.println("4) enviar string");
            System.out.println("5) enviar objeto Pessoa");
            System.out.println("6) enviar lista de Pessoa");
            System.out.println("7) chamar metodo void");
            System.out.println("8) chamar metodo double");
            System.out.println("0) SAIR");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    long startTimeInt = System.currentTimeMillis();
                    stub.sendInteger(10);
                    long finalTimeInt = System.currentTimeMillis() - startTimeInt;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimeInt + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimeInt) + "ms.");
                    break;
                case 2:
                    long startTimeLong = System.currentTimeMillis();
                    stub.sendLong(10L);
                    long finalTimeLong = System.currentTimeMillis() - startTimeLong;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimeLong + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimeLong) + "ms.");
                    break;
                case 3:
                    long startTimeLongs = System.currentTimeMillis();
                    stub.send8Longs(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);
                    long finalTimeLongs = System.currentTimeMillis() - startTimeLongs;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimeLongs + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimeLongs) + "ms.");
                    break;
                case 4:
                    System.out.println("Qual o tamanho da string?");
                    int size = sc.nextInt();
                    long startTimeString = System.currentTimeMillis();
                    stub.sendString(createString(size));
                    long finalTimeString = System.currentTimeMillis() - startTimeString;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimeString + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimeString) + "ms.");
                    break;
                case 5:
                    long startTimePessoa = System.currentTimeMillis();
                    stub.oiDaPessoa(new Pessoa("Guilherme", 19, 1.73, 9862951));
                    long finalTimePessoa = System.currentTimeMillis() - startTimePessoa;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimePessoa + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimePessoa) + "ms.");
                    break;
                case 6:
                    long startTimeLista = System.currentTimeMillis();
                    List<Pessoa> lista = criaListaCom3Pessoas();
                    stub.sendListaPessoa(lista);
                    long finalTimeLista = System.currentTimeMillis() - startTimeLista;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimeLista + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimeLista) + "ms.");
                    break;
                case 7:
                    long startTimeVoid = System.currentTimeMillis();
                    stub.voidFunction();
                    long finalTimeVoid = System.currentTimeMillis() - startTimeVoid;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimeVoid + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimeVoid) + "ms.");
                    break;
                case 8:
                    long startTimeDouble = System.currentTimeMillis();
                    stub.sendDouble(10.0);
                    long finalTimeDouble = System.currentTimeMillis() - startTimeDouble;
                    System.out.println("Tempo discorrido para execucao do metodo: " + finalTimeDouble + "ms.");
                    System.out.println("Tempo total discorrido (stub + metodo): " + (timeStub + finalTimeDouble) + "ms.");
                    break;
            }
        } while (opcao != 0);
    }

    private static List<Pessoa> criaListaCom3Pessoas() {
        List<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa("Guilherme Coppini Pavani", 19, 1.73, 9862951));
        lista.add(new Pessoa("Silvio Novaes de Lira Junior", 19, 1.74, 9778522));
        lista.add(new Pessoa("Lucas Bordinhon Capalbo", 19, 1.78, 9877982));
        return lista;
    }

    // Metodo auxiliar para criar Strings grandes/pequenas de acordo com a necessidade para testar o string
    private static String createString(int size) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += ".";
        }
        return result;
    }
}