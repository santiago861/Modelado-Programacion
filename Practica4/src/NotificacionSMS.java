public class NotificacionSMS extends Notificacion{
    private String numeroTelefono;

    public NotificacionSMS(String mensaje, String numeroTelefono) {
        super(mensaje);
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void enviar() {
        // Simula el envío de un mensaje sms mostrando un mensaje en la terminal
        System.out.println("Enviando un SMS a " + numeroTelefono);
        System.out.println("Asunto: Notificación por SMS");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Mensaje SMS enviado con éxito.");
    }
}
