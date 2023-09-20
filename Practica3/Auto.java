import java.sql.Blob;

public class Auto {
    private Llantas llantas; 
    private Motor motor; 
    private Carroceria carroceria;
    private Blindaje blindaje;
    private Armas armas; 
    private int ataqueTotal, defensaTotal, velocidadTotal, costoTotal;

    public Auto(Llantas llantas, Motor motor, Carroceria carroceria, Blindaje blindaje, Armas armas, int ataqueTotal, int defensaTotal, int velocidadTotal, int costoTotal) {
        this.llantas = llantas; 
        this.motor = motor; 
        this.carroceria = carroceria; 
        this.blindaje = blindaje; 
        this.armas = armas; 
        this.ataqueTotal = ataqueTotal; 
        this.defensaTotal = defensaTotal; 
        this.velocidadTotal = velocidadTotal; 
        this.costoTotal = costoTotal; 
    }
}
