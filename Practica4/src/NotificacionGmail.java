public class NotificacionGmail extends NotificacionDecorator{

    public NotificacionGmail(Notificacion notificacion){
        super(notificacion);
    }

    @Override
    public void mensaje (String mensaje){
        System.out.println("Mensaje Gmail enviado: " + mensaje);
    }

    public void destinatario(String destinatario){
    System.out.println("Has enviado el mensaje al correo: " + destinatario);
    }
}