// /**
//  * @author Yanez Diaz Carlos
//  * @author Reyes Medina Santiago Ivan
//  */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
        


    static ArrayList<String> users = new ArrayList<>();
      public static void main(String[] args) {
        int port = 7400; // Puerto en el que escuchará el servidor
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando una conexión en el puerto " + port + "...");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Conexión establecida desde " + socketCliente.getInetAddress() + ":" + socketCliente.getPort());
                // Crea un nuevo hilo para manejar la conexión del cliente
                Thread clientHandlerThread = new Thread(new ClienteHandler(socketCliente));
                clientHandlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Clase interna para manejar la conexión de cada cliente en un hilo separado
    private static class ClienteHandler implements Runnable {
        private Socket socketCliente;
        private BufferedReader inMsj;
        private BufferedReader inUser;
        private BufferedWriter out;

        public ClienteHandler(Socket socketCliente) {
            this.socketCliente = socketCliente;
        }

        @Override
        public void run() {
            try {
                inMsj = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                inUser = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()));
                String usuario; 
                String msjCliente;
                usuario = inUser.readLine();
                users.add(usuario);
                while (true) {
                    msjCliente = inMsj.readLine();
                    if (msjCliente == null) {
                        break; // Si el cliente cierra la conexión, salimos del bucle
                    }
                    System.out.println("Mensaje de "+ usuario + ":  "  + msjCliente);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inMsj != null) inMsj.close();
                    if (out != null) out.close();
                    if (socketCliente != null) socketCliente.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
