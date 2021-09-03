package ServerAndClients;

import java.net.InetAddress;

public class FinderIp {

    public static void main(String[] args) {
        InetAddress address;
        String url = "localhost";
        try {
            address = InetAddress.getByName(url);
            System.out.println("IP Adress = " + address.toString());
            address = InetAddress.getLocalHost();
            System.out.println(address.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
