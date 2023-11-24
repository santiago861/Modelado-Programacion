import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class InterfazCliente extends JPanel {

    private static final long serialVersionUID = 1L;

    private JFrame ventana;
    WindowListener exitListener;

    private JLabel labelClientes;
    private JTextArea chat;
    private JTextField campo;
    private JButton botonEnviar, botonSalir, botonLimpiar, botonListado;
    DefaultCaret caret;

    public InterfazCliente(JFrame ventana) {
        this.ventana = ventana;
        setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel(new GridBagLayout());
        JPanel panelSur = new JPanel(new GridBagLayout());

        labelClientes = new JLabel("Usuarios Conectados: 0");
        chat = new JTextArea();
        campo = new JTextField();
        botonListado = new JButton("Usuarios Conectados"); 
        botonSalir = new JButton("Salir");
        botonEnviar = new JButton("Enviar");
        botonLimpiar = new JButton("Limpiar chat");
        JScrollPane scroll = new JScrollPane(chat);

        Color backgroundColor = new Color(255, 255, 255);
        Color buttonColor = new Color(65, 105, 225);
        Color textColor = Color.BLACK;
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        setBackground(backgroundColor);
        panelNorte.setBackground(backgroundColor);
        panelSur.setBackground(backgroundColor);
        labelClientes.setFont(labelFont);
        labelClientes.setForeground(textColor);
        chat.setBackground(Color.WHITE);
        chat.setForeground(textColor);
        campo.setBackground(Color.WHITE);
        campo.setForeground(textColor);
        botonListado.setBackground(buttonColor);
        botonListado.setForeground(Color.WHITE);
        botonSalir.setBackground(buttonColor);
        botonSalir.setForeground(Color.WHITE);
        botonEnviar.setBackground(buttonColor);
        botonEnviar.setForeground(Color.WHITE);
        botonLimpiar.setBackground(buttonColor);
        botonLimpiar.setForeground(Color.WHITE);
        chat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        botonListado.setFocusPainted(false);
        botonSalir.setFocusPainted(false);
        botonEnviar.setFocusPainted(false);
        botonLimpiar.setFocusPainted(false);
        chat.setBorder(BorderFactory.createCompoundBorder(
                chat.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelNorte.add(labelClientes, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelNorte.add(botonListado, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelNorte.add(botonSalir, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelSur.add(botonLimpiar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelSur.add(campo, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelSur.add(botonEnviar, gbc);
        add(panelNorte, BorderLayout.NORTH);
        add(panelSur, BorderLayout.SOUTH);
        add(scroll, BorderLayout.CENTER);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        caret = (DefaultCaret) chat.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        setPreferredSize(new Dimension(480, 360));
        chat.setLineWrap(true);

        chat.setEditable(false);
        setEnabled(false);
    }
	public String getTextoCampo() {
		return campo.getText().toString();
	}
	public void vaciarTextoCampo() {
		campo.setText("");
	}
	
	public void setClientes(String clientes) {
		labelClientes.setText("Clientes en el chat: "+ clientes);
	}
	
	public void addText(String linea) {
		chat.append(linea+"\n");
	}
	
	public void limpiarChat() {
		chat.setText("");
	}
	
	public void setEnabled(boolean activado) {
		campo.setEnabled(activado);
		chat.setEnabled(activado);
		botonEnviar.setEnabled(activado);
		botonLimpiar.setEnabled(activado);
		botonListado.setEnabled(activado);
		botonSalir.setEnabled(activado);
	}
	
	public void setControlador(ClienteController l) {
		botonEnviar.setActionCommand("enviar");
		campo.setActionCommand("enviar");
		botonSalir.setActionCommand("salir");
		botonLimpiar.setActionCommand("limpiar");
		botonListado.setActionCommand("listado");
		
		botonEnviar.addActionListener(l);
		campo.addActionListener(l);
		botonSalir.addActionListener(l);
		botonLimpiar.addActionListener(l);
		botonListado.addActionListener(l);
		
		exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        l.salir();
		        System.exit(0);
		    }
		};
		ventana.addWindowListener(exitListener);
		
	}	
	
}
