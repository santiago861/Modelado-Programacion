public class AutoFactory {
    
    public static Llantas crearLlantas(String nombre) {
        return new Llantas(nombre);
    }
    public static Motor crearMotor(String nombre) {
        return new Motor(nombre);
    }
    public static Carroceria crearCarroceria(String nombre) {
        return new Carroceria(nombre);
    }
    public static Blindaje crearBlindaje(String nombre) {
        return new Blindaje(nombre);
    }
    public static Armas crearArmas(String nombre) {
        return new Armas(nombre);
    }

    public static Auto crearAuto(Llantas llantas, Motor motor, Carroceria carroceria, Blindaje blindaje, Armas armas) {
        int ataqueTotal = armas.getAtaque(); 
        int defensaTotal = blindaje.getDefensa() + carroceria.getDefensa();
        int velocidadTotal = llantas.getVelocidad() + motor.getVelocidad();
        int costoTotal = llantas.getCosto() + motor.getCosto() + carroceria.getCosto() + blindaje.getCosto() + armas.getCosto(); 

        return new Auto(llantas, motor, carroceria, blindaje, armas, ataqueTotal, defensaTotal, velocidadTotal, costoTotal);
    }
}
