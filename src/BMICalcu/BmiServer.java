package BMICalcu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BmiServer {
    public static void main(String[] args) {
    double bmi;

    try{
        ServerSocket sS = new ServerSocket(7070);
        System.out.println("Connection to port 7070 established");
        Socket socket = sS.accept();

        DataOutputStream dOS = new DataOutputStream(socket.getOutputStream());
        DataInputStream dIS = new DataInputStream(socket.getInputStream());


        while (true) {
            String weight = dIS.readUTF();
            String height = dIS.readUTF();
            System.out.println("Weight input from client " + weight);
            System.out.println("Height input from client " + height);

            bmi = Double.parseDouble(weight) / Math.pow(Double.parseDouble(height),2);
            dOS.writeUTF("your calculated bmi is = " + bmi);
            dOS.flush();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
