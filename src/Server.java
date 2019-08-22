import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8000);

            System.out.println("Serveren er oppe!");

            Socket socket = server.accept();

            System.out.println("Serveren har modtaget en forbindelse fra " + socket.getRemoteSocketAddress().toString());

            while (true) {

                DataInputStream in = new DataInputStream(socket.getInputStream());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                double aNumber = in.readDouble();
                System.out.println("Tallet modtaget fra clienten: " + aNumber);

                out.writeDouble(aNumber);

                if (aNumber == 0.0 ) { break; }
            }

        } catch (IOException e) {
            System.out.println("Serveren oplever teknisk fejl");

            e.printStackTrace();
        }


    }
}
