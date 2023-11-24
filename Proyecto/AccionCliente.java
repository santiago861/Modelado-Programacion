import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AccionCliente {

	private InterfazCliente vista;
	private ClienteController controlador;
	private Socket cliente;
	
	private BufferedReader entrada;
	private PrintWriter salida;
	
	public AccionCliente(Socket cliente, InterfazCliente vista, ClienteController controlador) throws IOException {
		this.cliente = cliente;
		this.vista = vista;
		this.controlador = controlador;
		entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		salida = new PrintWriter(cliente.getOutputStream(), true);
	}

	public String recibirTCP() throws IOException {
		String cadenaRecibida = null;
		do {
				cadenaRecibida = entrada.readLine();
		} while(cadenaRecibida==null);
			
		return cadenaRecibida;
	}
	public void enviarTCP(String cadena) {
			salida.println(cadena );
	}
	

	public void cerrarConexion() {
		try {
			entrada.close();
			salida.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public void handleMessage() {
		try {
			String msg = recibirTCP();
		
			switch(msg.trim()){
				// recibimos código de desconectar.
				case Constantes.CODIGO_SALIDA:
					
					controlador.salir();
					vista.addText("El servidor se ha apagado");
					
				break;
				// Recibimos actualizar numero clientes
				case Constantes.CODIGO_ACTUALIZAR_CONECTADOS:
					
					vista.setClientes(recibirTCP());
					
				break;
				default: // Recibimos un mensaje normal y corriente
					
					vista.addText(msg);
						
				break;
			}
	    	
		} catch (IOException e) {
			controlador.salir();
			vista.addText("Servidor desconectado.");
		}
    }
}
