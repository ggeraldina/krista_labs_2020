import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] argv) throws IOException {
        String networkPrefix = "192.168.175.";
        ArrayList<String> networkElements = new ArrayList<>();

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(1, TimeUnit.MILLISECONDS); // время ожидания подключения

        for (int i = 0; i <= 255; i++) {
            String ipAddress = networkPrefix + i;
            String clientUrl = "http://" + ipAddress + ":8000";
            System.out.printf("Checking IP %s\n", ipAddress);

            Request request = new Request.Builder() // запрос
                    .url(clientUrl)
                    .build();

            try {
                Response response = httpClient.newCall(request).execute(); // ответ
                String elementNetwork = String.format("%s - %s", ipAddress, response.body().string());
                networkElements.add(elementNetwork);
            } catch (IOException e) {
                // ignore error, no response for this ip === no server listening there
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream("result.txt", true);

        String result = "Network map:";
        if (!networkElements.isEmpty()) {
            for (String element : networkElements) {
                result = result + "\n" + networkElements;
            }
        } else {
            result += " empty";
        }
        System.out.println(result);
        fileOutputStream.write(result.getBytes());
        fileOutputStream.close();
    }
}
