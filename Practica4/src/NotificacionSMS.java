/**
 * Practica 4 del curso de Modelado y Programación
 * 
 * Clase Notificacion SMS extiende de Notificacion Decorator
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */

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