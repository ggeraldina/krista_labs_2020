import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        while (true) {
            try {
                try {
                    server = new ServerSocket(6000); // серверсокет прослушивает порт 6000
                    System.out.println("Сервер запущен"); // объявить о своем запуске
                    clientSocket = server.accept(); // accept() будет ждать пока кто-нибудь не захочет подключиться
                    try {
                        System.out.println("!!! Новый клиент");
                        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        out.write("Grushevskaya :)");
                        out.flush(); // выталкиваем все из буфера
                    } finally {
                        System.out.println("Сокет закрыт");
                        clientSocket.close();
                        out.close();
                    }
                } finally {
                    System.out.println("Сервер закрыт");
                    server.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}