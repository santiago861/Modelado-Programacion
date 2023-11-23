import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que tratará los eventos sobre los botones en la vista.
 */
public class ClienteController implements ActionListener {

	private UtilidadesCliente cliente;
	private VistaCliente vista;
	
	public ClienteController(VistaCliente vista) {
		this.vista = vista;
	}
	public void setCliente(UtilidadesCliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "salir":
				salir();
			break;
			case "enviar":
				cliente.enviarTCP(vista.getTextoCampo());
				vista.vaciarTextoCampo();
			break;
			case "listado":
				cliente.enviarTCP(Constantes.CODIGO_LISTAR);
			break;
			case "limpiar":
				vista.limpiarChat();
			break;
			default:
			break;
		}
	}
	public int salir() {
		cliente.enviarTCP(Constantes.CODIGO_SALIDA);
		cliente.cerrarConexion();
		vista.setClientes("Unknown");
		vista.addText("Has abandonado la sala de chat.");
		vista.setEnabled(false);
		return 0;
	}
}
