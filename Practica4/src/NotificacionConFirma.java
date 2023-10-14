public class NotificacionConFirma extends NotificacionDecorator{
    private String firma; 

    public NotificacionConFirma(Notificacion notificacionDecorada, String firma) {
        super(notificacionDecorada);
        this.firma = firma; 
    }

    public void agregarFirma() {
        System.out.println("Firma agregada: " + firma);
    }

    @Override
    public void enviar() {
        super.enviar();
        agregarFirma();
    }
}
