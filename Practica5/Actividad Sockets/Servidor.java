/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor{
    public static void main(String[] args) {
        int port = 7400; // Puerto en el que escuchará el servidor
        ServerSocket serverSocket = null;
        Socket socketCliente = null;
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando una conexión en el puerto " + port + "...");

            socketCliente = serverSocket.accept();
            System.out.println("Conexión establecida desde " + socketCliente.getInetAddress() + ":" + socketCliente.getPort());

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
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
