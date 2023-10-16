/**
 * Practica 4 del curso de Modelado y Programación
 * 
 * Clase abstracta Notificacion Decorator implementa Interfaz Notificacion
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */

public abstract class NotificacionDecorator implements Notificacion{

    Notificacion notificacion;

    public NotificacionDecorator (Notificacion notificacion){
        this.notificacion = notificacion;
    }

    protected Notificacion getNotificacion(){
        return notificacion;
    }
}