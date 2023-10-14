public class NotificacionEmail extends Notificacion{
    private String emailDestino;

    public NotificacionEmail(String mensaje, String emailDestino) {
        super(mensaje);
        this.emailDestino = emailDestino;
    }

    @Override
    public void enviar() {
        
    }
}
