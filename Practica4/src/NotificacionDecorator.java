

public abstract class NotificacionDecorator implements Notificacion{

    Notificacion notificacion;

    public NotificacionDecorator (Notificacion notificacion){
        this.notificacion = notificacion;
    }

    protected Notificacion getNotificacion(){
        return notificacion;
    }
}