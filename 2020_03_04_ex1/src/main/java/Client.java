import java.io.*;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileOutputStream;

public class Client {
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли
    private static BufferedReader in; // поток чтения из сокета

    public static void main(String[] args) throws IOException {
        ArrayList<String> networkElements = new ArrayList<String>();
        String ipNetwork = "192.168.52.";
        for(int i = 0; i <= 255; i++)  {
            String ipAddress = ipNetwork + i;
            System.out.println("Checked IP: " + ipAddress);
            try {
                clientSocket = new Socket();
                clientSocket.connect(new InetSocketAddress(ipAddress, 6000), 10);
                reader = new BufferedReader(new InputStreamReader(System.in)); // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                networkElements.add(ipAddress + " - " + in.readLine());
            } catch (IOException e) {
//                System.out.println("Error 1:" + e);
            } finally { // в любом случае необходимо закрыть сокет и потоки
                try {
                    clientSocket.close();
                    in.close();
                } catch (Exception e2) {
//                    System.out.println("Error 2:" + e2);
                }
            }
        }

        writeMap(networkElements);
    }

    private static void writeMap(ArrayList<String> networkElements) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("result.txt", false);
        String result = "Network map:";
        if (!networkElements.isEmpty()) {
            for (String element : networkElements) {
                result = result + "\n" + networkElements;
            }
        } else {
            result += " empty";
        }
        fileOutputStream.write(result.getBytes());
        fileOutputStream.close();

        System.out.println(result);
    }
}