import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет


//    https://stackoverflow.com/questions/2275443/how-to-timeout-a-thread
    public static void main(String[] args) {
        String ipNetwork = "192.168.175.";
        for(int i = 0; i <= 255; i++)  {
            String ipAddress = ipNetwork + i;
            try {
                System.out.println("0");
                clientSocket = new Socket(ipAddress, 6000); // этой строкой мы запрашиваем
                clientSocket.setSoTimeout(100);
                //  у сервера доступ на соединение
                System.out.println("1");
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                System.out.println("2");
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("3");
                System.out.println(in.readLine());
            } catch (IOException e) {
                System.out.println("1:" + e);
            } finally { // в любом случае необходимо закрыть сокет и потоки
                try {
                    System.out.println("Клиент был закрыт...");
//                    clientSocket.close();
//                    in.close();
                } catch (Exception e2) {
                    System.out.println("2:" + e2);
                }
            }
        }
    }
}