import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

/**
 * Clase que almacena los clientes que están conectados.
 */
public class ListaClientes {

	private static HashMap<String, HiloServidor> mapaClientes;
	
	public ListaClientes(){
		mapaClientes = new HashMap<String, HiloServidor>();
	}
	
	public int getClientesConectados() {
		return mapaClientes.size();
	}
	
	public void add(String nombre, HiloServidor cliente) {
		mapaClientes.put(nombre, cliente);
	}
	
	public void remove(String nombre) {
		mapaClientes.remove(nombre);
	}
	
	public boolean yaEstaDentro(String nombre) {
		return mapaClientes.containsKey(nombre);
	}
	
	public String getListaClientes() {
		StringBuilder clientes = new StringBuilder(250);
		
		// Recorremos las claves (nombres) de los clientes
		Set<String> claves = mapaClientes.keySet();
		for (String clave : claves) {
		   clientes.append(clave + ", ");
		}
		
		// Al final quitamos la coma e imprimimos punto
		clientes.setLength(clientes.length()-2);
		clientes.append(".");
				
		return clientes.toString().trim();
	}
	
	public void actualizarConectados() {
    	emitirATodos(Constantes.CODIGO_ACTUALIZAR_CONECTADOS);
    	emitirATodos(getClientesConectados() + "");
    }
	
	public void desconectarTodos() {
		Set<Map.Entry<String, HiloServidor>> set = mapaClientes.entrySet();
		for (@SuppressWarnings("rawtypes") Entry entry : set) {
			((HiloServidor) entry.getValue()).cerrarConexion();
		}
	}
	
	public void emitirATodos(String msg) {
		Set<Map.Entry<String, HiloServidor>> set = mapaClientes.entrySet();
		for (@SuppressWarnings("rawtypes") Entry entry : set) {
		   ((HiloServidor) entry.getValue()).enviarTCP(msg);
		}
	}
}
