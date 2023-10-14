public class NotificacionDecorator extends Notificacion{
    protected Notificacion notificacionDecorada;

    public NotificacionDecorator(Notificacion notificacionDecorada) {
        super(notificacionDecorada.mensaje);
        this.notificacionDecorada = notificacionDecorada;
    }

    @Override
    public void enviar() {
        
    }
}
