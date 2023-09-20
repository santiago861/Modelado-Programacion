public class AutoFactory {
    
    public Llantas crearLlantas(String nombre) {
        return new Llantas(nombre);
    }
    public Motor crearMotor(String nombre) {
        return new Motor(nombre);
    }
    public Carroceria crearCarroceria(String nombre) {
        return new Carroceria(nombre);
    }
    public Blindaje crearBlindaje(String nombre) {
        return new Blindaje(nombre);
    }
    public Armas crearArmas(String nombre) {
        return new Armas(nombre);
    }

    public Auto crearAuto(Llantas llantas, Motor motor, Carroceria carroceria, Blindaje blindaje, Armas armas) {
        // este metodo no es oficial pues supuestamente en la clase factory se deberia de crear un objeto sin la necesidad de pasar tantos parametros 
    }
}
