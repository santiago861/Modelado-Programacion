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

public class Servidor {
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
        private BufferedReader in;
        private BufferedWriter out;

        public ClienteHandler(Socket socketCliente) {
            this.socketCliente = socketCliente;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream()));

                String msjCliente;

                while (true) {
                    msjCliente = in.readLine();
                    if (msjCliente == null) {
                        break; // Si el cliente cierra la conexión, salimos del bucle
                    }
                    System.out.println("Mensaje del cliente: " + msjCliente);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                    if (socketCliente != null) socketCliente.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
