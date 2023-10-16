public class NotificacionSMS extends NotificacionDecorator{

    public NotificacionSMS(Notificacion notificacion){
        super(notificacion);
    }

    @Override
    public void mensaje (String mensaje){
        System.out.println("Mensaje SMS enviado: " + mensaje);
    }

    public void destinatario(String destinatario){
    System.out.println("Has enviado el mensaje al numero: " + destinatario);
    }
}