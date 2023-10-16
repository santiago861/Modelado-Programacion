/**
 * Practica 4 del curso de Modelado y Programación
 * 
 * Clase Notificacion Base implementa Interfaz Notificacion
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */

public class NotificacionBase implements Notificacion{

    public NotificacionBase(){

    }

    public void mensaje (String mensaje){
        System.out.println("Mensaje: ");
    }

    public void destinatario (String destinatario){
        System.out.println("Mensaje para: ");

    }

}