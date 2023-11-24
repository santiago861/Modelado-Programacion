import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class Servidor {
	
	private static JFrame ventana;
	private static VistaServidor vista;
	private static ClienteController controlador;
	public static ServerSocket servidor;
	private static ListaClientes clientes;
	
	public static void main(String[] args) {
		
		configurarVentana();
        lanzarVentana();
        
        try {
		    iniciarServidor();
		    
		    do {
	    		handleClient();
		    }while(!servidor.isClosed());
        } catch (BindException e) {
			vista.addText("Ya tienes una instancia del server abierta, MELÓN");
		} catch(IOException e) {
        	vista.addText("<SERVER FATAL ERROR> No fue posible iniciar el servidor (already running bruh?).");
        }
        
        while(true) {}
    }

	public static void imprimirConsola(String msg) {
		vista.addText(msg);
	}
	
	public static void imprimirTodos(String msg) {
		imprimirConsola(msg);
		clientes.emitirATodos(msg);
	}
	
	public static ListaClientes getClientes() {
		return clientes;
	}
		
	private static void configurarVentana() {

        ventana = new JFrame("Servidor de chat");
        vista = new VistaServidor();
        controlador = new ClienteController(vista);
        
        ventana.setContentPane(vista);
        vista.setControlador(controlador);
	}
	
    private static void lanzarVentana(){
        ventana.pack();
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void iniciarServidor() throws IOException {
		servidor = new ServerSocket(Constantes.PUERTO_SERVIDOR);
		clientes = new ListaClientes();
		controlador.setServidor(servidor);
		servidor.getInetAddress();
		vista.addText("<SERVER> Servidor iniciado en "+InetAddress.getLocalHost().getHostAddress());
    }
    

    private static void handleClient(){
    	try {
    		// Aceptamos el cliente.
	    	Socket cliente = servidor.accept();
	    	HiloServidor thread = new HiloServidor(vista, cliente);
			thread.start();
			
	    	thread.enviarTCP("aceptado");
    	}catch(IOException e) { /* Cuando no hay nadie intentando conectar */ }
    }
    
    public static void meterCliente(HiloServidor thread) {
    	clientes.add(thread.getNombre(), thread);
    	clientes.actualizarConectados();
    	vista.setClientesConectados(clientes.getClientesConectados());
    }
    
    public static void sacarCliente(String nombre) {
    	clientes.remove(nombre);
    	clientes.actualizarConectados();
    	vista.setClientesConectados(clientes.getClientesConectados());
    }    
}
