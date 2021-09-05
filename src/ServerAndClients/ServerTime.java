package ServerAndClients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTime {

    public static void main(String[] args) throws IOException {
        // Måden tiden og datoen bliver vist på, Med dag-Måned-år - Timer-Minutter-Sekunder.
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy" + " - " + "HH:mm:ss");

        System.out.println("ServerAndClients.Server established with Date & Time");

        // Herfra får man hvad klokken er lige nu.
        Date date = new Date(System.currentTimeMillis());

        // ny serversocket tilknyttet til port 4200.
        ServerSocket sS = new ServerSocket(4200);

        // Serveren venter clienten.
        Socket socket = sS.accept();



        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true) {
            out.writeUTF(fm.format(date) + "\n");
        }
    }

}
