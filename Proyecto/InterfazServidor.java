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
    

        // Aplicar estilos
        labelConexiones.setForeground(Color.BLACK);
        labelPuerto.setForeground(Color.BLACK);
        texto.setBackground(Color.WHITE);
        texto.setForeground(Color.BLACK);
        botonSalir.setBackground(new Color(65, 105, 225));
        botonSalir.setForeground(Color.WHITE);

        // Borde y otros ajustes
        texto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        botonSalir.setFocusPainted(false);

        // Añadir sombra suave
        texto.setBorder(BorderFactory.createCompoundBorder(texto.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelNorte.add(labelConexiones, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelNorte.add(labelPuerto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelSur.add(botonSalir, gbc);

        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelSur, BorderLayout.SOUTH);
        add(scroll, BorderLayout.CENTER);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        caret = (DefaultCaret) texto.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        texto.setLineWrap(true);

        setPreferredSize(new Dimension(480, 360));
    }

    public void setControlador(ActionListener l) {
        botonSalir.setActionCommand("apagar");
        botonSalir.addActionListener(l);
    }

    public void setClientesConectados(int clientesConectados) {
        labelConexiones.setText("Clientes conectados: " + clientesConectados);
    }

    public void addText(String linea) {
        texto.append(linea + "\n");
    }

    public void apagar() {
        botonSalir.setEnabled(false);
        texto.setEnabled(false);
        labelConexiones.setText("Servidor apagado.");
        labelPuerto.setText("Puerto: -");
    }

    @Deprecated
    public void sumarCliente() {
        clientesConectados++;
        labelConexiones.setText("Clientes conectados: " + clientesConectados);
    }

    @Deprecated
    public void restarCliente() {
        clientesConectados--;
        labelConexiones.setText("Clientes conectados: " + clientesConectados);
    }

}
