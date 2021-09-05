package ServerAndClients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            // Laver en socket på Localhost med port nummeret 4200
            Socket socket = new Socket("localhost", 4200);

            // Data for ind og ud af serveren.
            DataInputStream dIS = new DataInputStream(socket.getInputStream());
            DataOutputStream dOS = new DataOutputStream(socket.getOutputStream());



            Scanner scanner = new Scanner(System.in);

            // Et While loop for at gøre så serverne kan modtage data for clienten mere end 1 gang.
            while(true) {
                dOS.writeUTF(scanner.nextLine());
                dOS.flush();
                System.out.println(dIS.readUTF());


            }

         }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
