
/*
 * Carrocerıa: casual, camion, deportiva
 */
public class Carroceria {
    private String nombre;
    private int defensa, costo; 
    
    public Carroceria(String n) {
        if (n == "casual") {
            this.nombre = "casual";  
            this.defensa = 3; 
            this.costo = 2;
        } else if (n == "camion"){
            this.nombre = "camion"; 
            this.defensa = 5; 
            this.costo = 4;
        } else if (n == "deportiva"){
            this.nombre = "deportiva"; 
            this.defensa = 2; 
            this.costo = 1;
        } 
    }
}
