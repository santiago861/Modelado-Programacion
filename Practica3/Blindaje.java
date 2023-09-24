
/*
 * Blindaje: simple, reforzado, tanque
 */
public class Blindaje {
    private String nombre;
    private int defensa, costo; 
    
    public Blindaje(String n) {
        if ("simple".equals(n)) {
            this.nombre = "simple";  
            this.defensa = 2; 
            this.costo = 1;
        } else if ("reforzado".equals(n)){
            this.nombre = "reforzado"; 
            this.defensa = 3; 
            this.costo = 2;
        } else if ("tanque".equals(n)){
            this.nombre = "tanque"; 
            this.defensa = 5; 
            this.costo = 4;
        } 
    }

    public String getNombre(){
        return nombre; 
    } 
    public int getDefensa() {
        return defensa; 
    }
    public int getCosto() {
        return costo; 
    }
}
