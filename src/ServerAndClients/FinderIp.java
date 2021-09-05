package ServerAndClients;

import java.net.InetAddress;

public class FinderIp {

    public static void main(String[] args) {
        InetAddress address;
        String url = "localhost";
        try {
            // Giver url og ip adress for koden.
            address = InetAddress.getByName(url);
            System.out.println("IP Adress = " + address.toString());

            // Finder navn på computeren samt IP adressen. halvt eksempel:
            // Andreas-Stationær/(Ip adress)
            address = InetAddress.getLocalHost();
            System.out.println(address.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
