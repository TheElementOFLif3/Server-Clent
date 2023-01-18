import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();

        Socket socket = new Socket("localhost", 1234);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeInt(num1);
        dataOutputStream.writeInt(num2);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int result = dataInputStream.readInt();

        System.out.println("The total is: " + result);
        
        socket.close();
    }
}
