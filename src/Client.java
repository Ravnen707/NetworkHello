
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 4200);

            DataInputStream dIS = new DataInputStream(socket.getInputStream());
            DataOutputStream dOS = new DataOutputStream(socket.getOutputStream());



            Scanner scanner = new Scanner(System.in);
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
