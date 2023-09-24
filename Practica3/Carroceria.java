
/*
 * Carrocerıa: casual, camion, deportiva
 */
public class Carroceria {
    private String nombre;
    private int defensa, costo; 
    
    public Carroceria(String n) {
        if ("casual".equals(n)) {
            this.nombre = "casual";  
            this.defensa = 3; 
            this.costo = 2;
        } else if ("camion".equals(n)){
            this.nombre = "camion"; 
            this.defensa = 5; 
            this.costo = 4;
        } else if ("deportiva".equals(n)){
            this.nombre = "deportiva"; 
            this.defensa = 2; 
            this.costo = 1;
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
