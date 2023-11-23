import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;


/**
 * Controlador de botones para el servidor.
 */
public class ServidorController implements ActionListener {

	private VistaServidor vista;
	private ServerSocket servidor;
	public ServidorController(VistaServidor vista) {
		this.vista = vista;
	}
	public void setServidor(ServerSocket servidor) {
		this.servidor = servidor;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		switch(ae.getActionCommand()){
			case "apagar":
				try {
					do {
						Servidor.getClientes().desconectarTodos();
						servidor.close();
						vista.addText("Se ha apagado el servidor.");
						vista.apagar();
					}while(!servidor.isClosed());
				} catch (IOException e) {	vista.addText("Ya estaba apagado."); }
			break;
			default:
				
			break;
		}
	}

}
