import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStreamWriter;

public class Interfaz extends JFrame {
    private JButton chatsButton;
    private BufferedWriter out;

    public Interfaz(BufferedWriter out) {
        super("Cliente Interfaz");
        this.out = out;

        // Configuración de la interfaz
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200); // Aumenté el tamaño para mejorar la presentación
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        chatsButton = new JButton("Chats");
        chatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaChats();
            }
        });

        add(chatsButton, BorderLayout.CENTER);
    }

    private void abrirVentanaChats() {
        // Aquí deberías obtener la lista de usuarios conectados y crear botones para cada uno
        // En este ejemplo, simplemente mostraremos botones ficticios
        String[] usuariosConectados = {"Usuario1", "Usuario2", "Usuario3"};

        JFrame ventanaChats = new JFrame("Chats");
        ventanaChats.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaChats.setSize(300, 200);
        ventanaChats.setLayout(new GridLayout(usuariosConectados.length, 1));

        for (String usuario : usuariosConectados) {
            JButton usuarioButton = new JButton(usuario);
            usuarioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    abrirVentanaChat(usuario);
                }
            });
            ventanaChats.add(usuarioButton);
        }

        ventanaChats.setVisible(true);
    }

    private void abrirVentanaChat(String usuario) {
        // Aquí deberías abrir una nueva ventana para el chat con el usuario seleccionado
        // En este ejemplo, simplemente mostraremos un mensaje
        JOptionPane.showMessageDialog(this, "Abrir chat con " + usuario);
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
