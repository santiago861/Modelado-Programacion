public class NotificacionPush extends Notificacion{
    private String emailDestino;

    public NotificacionPush(String mensaje, String emailDestino) {
        super(mensaje);
        this.emailDestino = emailDestino;
    }

    @Override
    public void enviar() {
        
    }
}
