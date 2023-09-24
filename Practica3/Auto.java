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

    public int getCostoTotal(){
        return costoTotal;
    } 

    @Override
    public String toString() {
        String cadena1 = "Se ha creado tu auto exitosamente \n"; 
        String cadena2 = "Las llantas son de tipo " + llantas.getNombre() + ", el motor es de tipo " + motor.getNombre() + ", la carroceria es de tipo "
                            + carroceria.getNombre() + ", el blindaje es de tipo " + blindaje.getNombre() + " y las armas son " + armas.getNombre() + "\n";
        String cadena3 = "El ataque total de tu nuevo auto es de " + ataqueTotal + " puntos, la defensa total es de " + defensaTotal + 
                            " puntos, la velocidad total es de " + velocidadTotal + " puntos. Por último el costo final del auto es de " + costoTotal +
                            " puntos.";

        String cadena = cadena1 + cadena2 + cadena3;
        return cadena;
    }
}
