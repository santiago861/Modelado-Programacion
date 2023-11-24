import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 * Ventana del servidor.
 */
public class InterfazServidor extends JPanel {

    private static final long serialVersionUID = 1L;

    @Deprecated
    private int clientesConectados;

    private JLabel labelConexiones, labelPuerto;
    private JButton botonSalir;
    private JTextArea texto;

    DefaultCaret caret;

    public InterfazServidor() {
        setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new GridBagLayout());
        JPanel panelSur = new JPanel(new GridBagLayout());
        clientesConectados = 0;
        labelConexiones = new JLabel("Clientes conectados: 0");
        labelPuerto = new JLabel("Puerto: " + Constantes.PUERTO_SERVIDOR);
        botonSalir = new JButton("Apagar servidor");
        texto = new JTextArea();
        texto.setEditable(false);
        JScrollPane scroll = new JScrollPane(texto);
    }

}
