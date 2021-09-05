package ServerAndClients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {

        int port = 4200;

        new Thread( () -> {
            try {

                //Step 1. ServerSocket lavet med en "port".
                ServerSocket serverSocket = new ServerSocket(port);

                //Step 2. Socket skal reagere.
                System.out.println("Accept connection port " + port);

                Socket socket = serverSocket.accept();

                System.out.println("Connection establilished from " + socket.getRemoteSocketAddress().toString());

                //Step 3. Data der skal ind og ud af serveren.
                DataInputStream dIS = new DataInputStream(socket.getInputStream());
                DataOutputStream dOS = new DataOutputStream(socket.getOutputStream());

                //Final Step. Data bliver sendt og modtaget.
                while (true) {
                    String incomingText = dIS.readUTF();
                    System.out.println("Cliant Data " + incomingText);
                    dOS.writeUTF(incomingText);
                    dOS.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
