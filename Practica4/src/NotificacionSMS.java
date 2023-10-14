public class NotificacionSMS extends Notificacion{
    private String emailDestino;

    public NotificacionSMS(String mensaje, String emailDestino) {
        super(mensaje);
        this.emailDestino = emailDestino;
    }

    @Override
    public void enviar() {
        
    }
}
