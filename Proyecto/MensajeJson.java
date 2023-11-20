public class MensajeJson{

    String tipoMensaje;
    String usuario;
    String estado;
    String destinatario;
    String mensaje;

    public MensajeJson (String tipoMensaje, String usuario, String estado, String destinatario, String mensaje){
        this.tipoMensaje = tipoMensaje;
        this.usuario = usuario;
        this.estado = estado;
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }

    public String toString() {
        return  "tipoMensaje='" + tipoMensaje + '\'' +
                ", usuario='" + usuario + '\'' +
                ", estado='" + estado + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", mensaje='" + mensaje + '\'';
    }
    
}