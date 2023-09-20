
/*
 * Blindaje: simple, reforzado, tanque
 */
public class Blindaje {
    private String nombre;
    private int defensa, costo; 
    
    public Blindaje(String n) {
        if (n == "simple") {
            this.nombre = "simple";  
            this.defensa = 2; 
            this.costo = 1;
        } else if (n == "reforzado"){
            this.nombre = "reforzado"; 
            this.defensa = 3; 
            this.costo = 2;
        } else if (n == "tanque"){
            this.nombre = "tanque"; 
            this.defensa = 5; 
            this.costo = 4;
        } 
    }
}
