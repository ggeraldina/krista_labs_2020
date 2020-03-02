import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;

public class consoleApp  {
    public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }
    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Display name: %s\n", netint.getDisplayName());

        byte[] hardwareAddress = netint.getHardwareAddress();
        if (hardwareAddress != null) {
            out.print("MAC: ");
            for (byte b : hardwareAddress) {
                out.printf("%02X ", b);
            }
            out.println();

        }

        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("IP: %s\n", inetAddress);
        }
        out.printf("\n");
    }

}
