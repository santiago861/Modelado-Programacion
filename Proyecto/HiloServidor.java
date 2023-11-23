import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Hilo del servidor que tratará al cliente.
 */
public class HiloServidor extends Thread {

	private Socket cliente;
	private VistaServidor vista;
	
	private BufferedReader entrada;
	private PrintWriter salida;	
	
	private String nombre;
	
	public HiloServidor(VistaServidor vista, Socket cliente) throws IOException {
		this.vista = vista;
		this.cliente = cliente;
		this.cliente.setSoTimeout(5000);
		nombre = "";
		entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		salida = new PrintWriter(cliente.getOutputStream(), true);
	}
	
	public void run() {
		String cadena;
		inicializacionCliente();
		try {
			do {
				cadena = recibirTCP();
				messageHandler(cadena.trim());
			}while(!cadena.trim().equals(Constantes.CODIGO_SALIDA));
			
			entrada.close();
			salida.close();
			cliente.close();
		} catch(SocketTimeoutException e) { 
			Servidor.imprimirTodos("<SERVER> "+nombre+" se ha caído (connection timeout).");
			Servidor.sacarCliente(nombre);
		} catch(IOException e) { Servidor.imprimirTodos("<SERVER> "+nombre+" desconectado dolorosamente."); }
		vista.setClientesConectados(Servidor.getClientes().getClientesConectados());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void cerrarConexion() {
		enviarTCP(Constantes.CODIGO_SALIDA);
	}
	
	private void messageHandler(String mensaje) {
		switch(mensaje.trim()) {
			case Constantes.CODIGO_SALIDA:
				
				Servidor.imprimirTodos("<SERVER> "+ nombre+ " ha abandonado el chat.");
				Servidor.sacarCliente(nombre);
				
			break;
			case Constantes.CODIGO_LISTAR:
				enviarTCP("<SERVER> CLIENTES CONECTADOS: " + new String(Servidor.getClientes().getListaClientes()));
			break;
			default:
				
				Servidor.imprimirTodos(nombre+": "+ mensaje);
				
			break;
		}
	}

	private void inicializacionCliente() {
    	nombre = nombreNoRepetido(recibirTCP());
		
		Servidor.meterCliente(this);
		Servidor.getClientes().actualizarConectados();
		Servidor.imprimirTodos("<SERVER> "+ nombre + " se ha unido al chat.");
	}

	private String nombreNoRepetido(String nombreViejo) {
    	String nuevoNombre = nombreViejo; int i = 1;
    	while(Servidor.getClientes().yaEstaDentro(nuevoNombre)) { 
    		nuevoNombre = nombreViejo.concat(Integer.toString(i));
    		i++; 
    	}
    	return nuevoNombre;
	}
	
	public String recibirTCP() {
		String cadenaRecibida = null;
		do {
			try {
				cadenaRecibida = entrada.readLine();
			} catch (IOException e) { cadenaRecibida = null; }
		} while(cadenaRecibida == null);
			
		return cadenaRecibida;
	}
	
	public void enviarTCP(String cadena) {
			salida.println(cadena );
	}	
}
