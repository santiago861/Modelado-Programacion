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
	
	/* ======================== Métodos Básicos ========================== */
	
	public int getClientesConectados() {
		return mapaClientes.size();
	}
	
	public void add(String nombre, HiloServidor cliente) {
		mapaClientes.put(nombre, cliente);
	}
	
	public void remove(String nombre) {
		mapaClientes.remove(nombre);
	}
	
	/**
	 * Devuelve true si un cliente se encuentra en la lista.
	 */
	public boolean yaEstaDentro(String nombre) {
		return mapaClientes.containsKey(nombre);
	}
}