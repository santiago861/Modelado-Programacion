import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

public class Interfaz extends JFrame {
    private final BufferedWriter out;
    private JTextField usuarioField;
    private String nombreUsuario;

    public Interfaz(BufferedWriter out) {
        super("Ventana de Ingreso");

        this.out = out;

        // Configurar la interfaz de ingreso
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Crear componentes
        JLabel mensajeLabel = new JLabel("Ingrese su nombre de usuario:");
        usuarioField = new JTextField();
        JButton ingresarButton = new JButton("Ingresar");

        // Configurar el diseño
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(mensajeLabel);
        panel.add(usuarioField);
        panel.add(ingresarButton);
        add(panel, BorderLayout.CENTER);

        // Configurar el evento del botón de ingresar
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre de usuario ingresado
                nombreUsuario = usuarioField.getText();

                // Ocultar la ventana de ingreso
                setVisible(false);
                // Mostrar la nueva interfaz con opciones
                mostrarInterfazPrincipal();
            }
        });
    }

    private void mostrarInterfazPrincipal() {
        // Crear la nueva interfaz con opciones
        JFrame principalFrame = new JFrame("Interfaz Principal");
        principalFrame.setSize(300, 150);
        principalFrame.setLocationRelativeTo(null);
    
        // Crear componentes para la nueva interfaz
        JLabel opcionesLabel = new JLabel("¿Qué deseas hacer, " + nombreUsuario + "?");
        JButton enviarMensajeButton = new JButton("Enviar Mensaje");
        JButton verListaButton = new JButton("Ver Lista de Usuarios Conectados");
        JButton salirButton = new JButton("Salir");
    
        // Nuevo botón para configurar estado de conexión
        JButton configurarConexionButton = new JButton("Configurar Estado de Conexión");
    
        // Configurar el diseño de la nueva interfaz
        principalFrame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(opcionesLabel);
        panel.add(enviarMensajeButton);
        panel.add(verListaButton);
        panel.add(configurarConexionButton); // Agregar el nuevo botón
        panel.add(salirButton);
        principalFrame.add(panel, BorderLayout.CENTER);
    
        // Configurar el evento del botón de enviar mensaje
        enviarMensajeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar la interfaz principal
                principalFrame.setVisible(false);
                // Mostrar la interfaz de enviar mensaje
                mostrarInterfazTipoMensaje();
            }
        });
    
        // Configurar el evento del botón de ver lista
        verListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para ver la lista de usuarios conectados
                JOptionPane.showMessageDialog(principalFrame, "Lógica para ver la lista de usuarios conectados");
            }
        });
    
        // Configurar el evento del botón de salir
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la interfaz principal
                principalFrame.dispose();
            }
        });
    
        // Configurar el evento del nuevo botón de configurar estado de conexión
        configurarConexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la interfaz para configurar estado de conexión
                mostrarInterfazConfiguracionEstado(principalFrame);
            }
        });
    
        principalFrame.setVisible(true);
    }
    
    // Nuevo método para mostrar la interfaz de configuración de estado de conexión
    private void mostrarInterfazConfiguracionEstado(JFrame parentFrame) {
        // Crear la interfaz para configurar estado de conexión
        JFrame configuracionEstadoFrame = new JFrame("Configuración de Estado de Conexión");
        configuracionEstadoFrame.setSize(300, 150);
        configuracionEstadoFrame.setLocationRelativeTo(null);
    
        // Crear componentes para la nueva interfaz
        JLabel estadoLabel = new JLabel("Selecciona tu estado de conexión:");
        JButton activoButton = new JButton("Activo");
        JButton awayButton = new JButton("Away");
        JButton ocupadoButton = new JButton("Ocupado");
    
        // Configurar el diseño de la nueva interfaz
        configuracionEstadoFrame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(estadoLabel);
        panel.add(activoButton);
        panel.add(awayButton);
        panel.add(ocupadoButton);
        configuracionEstadoFrame.add(panel, BorderLayout.CENTER);
    
        // Configurar el evento del botón Activo
        activoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para configurar estado como Activo
                JOptionPane.showMessageDialog(configuracionEstadoFrame, "Estado configurado como Activo");
                // Cerrar la interfaz de configuración de estado
                configuracionEstadoFrame.dispose();
                // Regresar a la interfaz principal
                parentFrame.setVisible(true);
            }
        });
    
        // Configurar el evento del botón Away
        awayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para configurar estado como Away
                JOptionPane.showMessageDialog(configuracionEstadoFrame, "Estado configurado como Away");
                // Cerrar la interfaz de configuración de estado
                configuracionEstadoFrame.dispose();
                // Regresar a la interfaz principal
                parentFrame.setVisible(true);
            }
        });
    
        // Configurar el evento del botón Ocupado
        ocupadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para configurar estado como Ocupado
                JOptionPane.showMessageDialog(configuracionEstadoFrame, "Estado configurado como Ocupado");
                // Cerrar la interfaz de configuración de estado
                configuracionEstadoFrame.dispose();
                // Regresar a la interfaz principal
                parentFrame.setVisible(true);
            }
        });
    
        configuracionEstadoFrame.setVisible(true);
    }

    private void mostrarInterfazTipoMensaje() {
        // Crear la interfaz para seleccionar el tipo de mensaje
        JFrame tipoMensajeFrame = new JFrame("Tipo de Mensaje");
        tipoMensajeFrame.setSize(300, 150);
        tipoMensajeFrame.setLocationRelativeTo(null);

        // Crear componentes para la nueva interfaz
        JLabel tipoMensajeLabel = new JLabel("Selecciona el tipo de mensaje:");
        JButton publicoButton = new JButton("Público");
        JButton privadoButton = new JButton("Privado");

        // Configurar el diseño de la nueva interfaz
        tipoMensajeFrame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(tipoMensajeLabel);
        panel.add(publicoButton);
        panel.add(privadoButton);
        tipoMensajeFrame.add(panel, BorderLayout.CENTER);

        // Configurar el evento del botón público
        publicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar la interfaz de seleccionar tipo de mensaje
                tipoMensajeFrame.setVisible(false);
                // Mostrar la interfaz para enviar mensaje público
                mostrarInterfazMensajePublico();
            }
        });

        // Configurar el evento del botón privado
        privadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ocultar la interfaz de seleccionar tipo de mensaje
                tipoMensajeFrame.setVisible(false);
                // Mostrar la interfaz para ingresar destinatario
                mostrarInterfazDestinatario();
            }
        });

        tipoMensajeFrame.setVisible(true);
    }

    private void mostrarInterfazMensajePublico() {
        // Crear la interfaz para enviar mensaje público
        JFrame mensajePublicoFrame = new JFrame("Mensaje Público");
        mensajePublicoFrame.setSize(300, 150);
        mensajePublicoFrame.setLocationRelativeTo(null);

        // Crear componentes para la nueva interfaz
        JLabel mensajeLabel = new JLabel("Escribe tu mensaje:");
        JTextField mensajeField = new JTextField();
        JButton enviarButton = new JButton("Enviar");

        // Configurar el diseño de la nueva interfaz
        mensajePublicoFrame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(mensajeLabel);
        panel.add(mensajeField);
        panel.add(enviarButton);
        mensajePublicoFrame.add(panel, BorderLayout.CENTER);

        // Configurar el evento del botón enviar
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para enviar mensaje público
                JOptionPane.showMessageDialog(mensajePublicoFrame, "Lógica para enviar mensaje público: " + mensajeField.getText());
                // Cerrar la interfaz de enviar mensaje público
                mensajePublicoFrame.dispose();
                // Mostrar la interfaz principal nuevamente
                mostrarInterfazPrincipal();
            }
        });

        mensajePublicoFrame.setVisible(true);
    }

    private void mostrarInterfazDestinatario() {
        // Crear la interfaz para ingresar el destinatario
        JFrame destinatarioFrame = new JFrame("Destinatario");
        destinatarioFrame.setSize(300, 150);
        destinatarioFrame.setLocationRelativeTo(null);

        // Crear componentes para la nueva interfaz
        JLabel destinatarioLabel = new JLabel("Ingresa el destinatario:");
        JTextField destinatarioField = new JTextField();
        JButton confirmarButton = new JButton("Confirmar");

        // Configurar el diseño de la nueva interfaz
        destinatarioFrame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(destinatarioLabel);
        panel.add(destinatarioField);
        panel.add(confirmarButton);
        destinatarioFrame.add(panel, BorderLayout.CENTER);

        // Configurar el evento del botón confirmar
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para confirmar destinatario
                JOptionPane.showMessageDialog(destinatarioFrame, "Destinatario confirmado: " + destinatarioField.getText());
                // Cerrar la interfaz de ingresar destinatario
                destinatarioFrame.dispose();
                // Mostrar la interfaz para enviar mensaje privado
                mostrarInterfazMensajePrivado(destinatarioField.getText());
            }
        });

        destinatarioFrame.setVisible(true);
    }

    private void mostrarInterfazMensajePrivado(String destinatario) {
        // Crear la interfaz para enviar mensaje privado
        JFrame mensajePrivadoFrame = new JFrame("Mensaje Privado");
        mensajePrivadoFrame.setSize(300, 150);
        mensajePrivadoFrame.setLocationRelativeTo(null);

        // Crear componentes para la nueva interfaz
        JLabel mensajeLabel = new JLabel("Escribe tu mensaje:");
        JTextField mensajeField = new JTextField();
        JButton enviarButton = new JButton("Enviar");

        // Configurar el diseño de la nueva interfaz
        mensajePrivadoFrame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(mensajeLabel);
        panel.add(mensajeField);
        panel.add(enviarButton);
        mensajePrivadoFrame.add(panel, BorderLayout.CENTER);

        // Configurar el evento del botón enviar
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para enviar mensaje privado
                JOptionPane.showMessageDialog(mensajePrivadoFrame, "Lógica para enviar mensaje privado a " + destinatario + ": " + mensajeField.getText());
                // Cerrar la interfaz de enviar mensaje privado
                mensajePrivadoFrame.dispose();
                // Mostrar la interfaz principal nuevamente
                mostrarInterfazPrincipal();
            }
        });

        mensajePrivadoFrame.setVisible(true);
    }
}
