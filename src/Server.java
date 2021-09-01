
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {

        int port = 4200;

        new Thread( () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);

                System.out.println("Accept connection port " + port);

                Socket socket = serverSocket.accept();

                System.out.println("Connection establilished from " + socket.getRemoteSocketAddress().toString());

                DataInputStream dIS = new DataInputStream(socket.getInputStream());
                DataOutputStream dOS = new DataOutputStream(socket.getOutputStream());

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
