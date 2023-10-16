public class NotificacionFacebook extends NotificacionDecorator{

    public NotificacionFacebook(Notificacion notificacion){
        super(notificacion);
    }

    @Override
    public void mensaje (String mensaje){
        System.out.println("Menseenger enviado: " + mensaje);
    }

    public void destinatario(String destinatario){
    System.out.println("Has enviado el mensaje al usuario: " + destinatario);
    }
}