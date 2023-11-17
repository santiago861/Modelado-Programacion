import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStreamWriter;

public class Interfaz extends JFrame {
    private JButton enviarButton;
    private JTextField mensajeField;
    private BufferedWriter out;

    public Interfaz(BufferedWriter out) {
        super("Cliente Interfaz");
        this.out = out;

        // Configuración de la interfaz
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        mensajeField = new JTextField();
        enviarButton = new JButton("Enviar");

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });

        add(mensajeField);
        add(enviarButton);
    }

    private void enviarMensaje() {
        String mensaje = mensajeField.getText();
        try {
            out.write(mensaje + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Código del cliente para conectar y crear la instancia de la interfaz
        String serverHost = "127.0.0.1";
        int serverPort = 7400;
        Socket socket = null;
        BufferedWriter out = null;

        try {
            socket = new Socket(serverHost, serverPort);
            System.out.println("Conectado al servidor...");

            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Crear instancia de la interfaz y hacerla visible
            Interfaz interfaz = new Interfaz(out);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    interfaz.setVisible(true);
                }
            });

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
