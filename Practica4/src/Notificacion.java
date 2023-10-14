public abstract class Notificacion {
    protected String mensaje; 

    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
    }

    public abstract void enviar();
} 