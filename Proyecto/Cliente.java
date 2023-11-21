/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String serverHost = "127.0.0.1";
        int serverPort = 7400; // Puerto del servidor
        Socket socket = null;
        BufferedWriter out = null;

        try {
            socket = new Socket(serverHost, serverPort);
            System.out.println("Conectado al servidor...");

            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Crear instancia de la interfaz y pasar el BufferedWriter
            Interfaz interfaz = new Interfaz(out);
            interfaz.setVisible(true);

            // Esperar a que la interfaz se cierre antes de cerrar la conexión
            while (interfaz.isVisible()) {
                // Espera activa
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
