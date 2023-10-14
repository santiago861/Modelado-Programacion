public class NotificacionEmail extends Notificacion{
    private String emailDestino;

    public NotificacionEmail(String mensaje, String emailDestino) {
        super(mensaje);
        this.emailDestino = emailDestino;
    }

    @Override
    public void enviar() {
        // Simula el envío de correo electrónico mostrando un mensaje en la terminal
        System.out.println("Enviando un correo electrónico a " + emailDestino);
        System.out.println("Asunto: Notificación por Email");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo electrónico enviado con éxito.");
    }
}
