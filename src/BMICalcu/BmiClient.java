package BMICalcu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BmiClient {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",7070);

            DataInputStream dIS = new DataInputStream(socket.getInputStream());
            DataOutputStream dOS = new DataOutputStream(socket.getOutputStream());

            Scanner scan = new Scanner(System.in);

            while (true) {
                System.out.println("Please enter your weight: ");
                dOS.writeUTF(scan.nextLine());
                System.out.println("Please enter you height in meter: ");
                dOS.writeUTF(scan.nextLine());

                dOS.flush();
                System.out.println(dIS.readUTF());
            }
        }


        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
