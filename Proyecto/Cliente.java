import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Cliente {
	
	private static JFrame ventana;
	private static InterfazCliente vista;
	private static ClienteController controlador;
	private static Socket cliente;
	private static AccionCliente utilidades;
	
	public static void main(String[] args) {
		
		configurarVentana();
		
		try {
			
			iniciarCliente();
			
			while(!cliente.isClosed()) {
				utilidades.handleMessage();
			}
			
			while(true) {}
		} catch (SocketTimeoutException e) {
			vista.setEnabled(false);
			JOptionPane.showMessageDialog(ventana, "Conexión perdida (connection timeout)", "Error de conexión", JOptionPane.ERROR_MESSAGE);
		} catch (SocketException e) {
			vista.setEnabled(false);
			JOptionPane.showMessageDialog(ventana, "Servidor no alcanzado. Apagado o fuera de covertura.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(ventana, e.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
		} 
		
	}

	private static void configurarVentana() {

        ventana = new JFrame("Cliente de chat");
        vista = new InterfazCliente(ventana);
        controlador = new ClienteController(vista);

        ventana.setContentPane(vista);
        vista.setControlador(controlador);
        ventana.pack();
        ventana.setResizable(false);
	}

    private static void iniciarCliente() throws NumberFormatException, IOException {
    	String nickname = JOptionPane.showInputDialog(ventana, "Introduce tu nickname", "Datos necesarios", JOptionPane.QUESTION_MESSAGE);
    	String puerto = "42455";
  		String host = "localhost";
		
    	try {
    		if(nickname.equals(""))
    			throw new IOException("Nickname no válido.");
    		cliente = new Socket();
    		cliente.connect(new InetSocketAddress(host, Integer.parseInt(puerto)), 5000);
    		utilidades = new AccionCliente(cliente, vista, controlador);
    		iniciarChat(nickname);
			
    	}catch(NumberFormatException e) {
    		JOptionPane.showMessageDialog(ventana, "Debes introducir un número de usuario válido.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    private static void iniciarChat(String nick) throws IOException {
    	ventana.setVisible(true);
		vista.setEnabled(true);
		controlador.setCliente(utilidades);
		utilidades.enviarTCP(nick);
    }
    
    
}
