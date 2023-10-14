public class NotificacionPush extends Notificacion{
    private String usuarioDestino;

    public NotificacionPush(String mensaje, String usuarioDestino) {
        super(mensaje);
        this.usuarioDestino = usuarioDestino;
    }

    @Override
    public void enviar() {
        // Simula el envío de una notificacion a un usuario mostrando un mensaje en la terminal
        System.out.println("Enviando un mensaje a " + usuarioDestino);
        System.out.println("Asunto: Notificación");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Notificacion enviada con éxito.");
    }
}
