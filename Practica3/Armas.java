
/*
 * Armas: arpones, lanzallamas, cañones, sierra, metralleta
 */
public class Armas {
    private String nombre;
    private int ataque, costo; 
    
    public Armas(String n) {
        if ("arpones".equals(n)) {
            this.nombre = "arpones";  
            this.ataque = 2; 
            this.costo = 2;
        } else if ("lanzallamas".equals(n)){
            this.nombre = "lanzallamas"; 
            this.ataque = 3; 
            this.costo = 3;
        } else if ("cañones".equals(n)){
            this.nombre = "cañones"; 
            this.ataque = 3; 
            this.costo = 2;
        } else if ("sierra".equals(n)){
            this.nombre = "sierra"; 
            this.ataque = 3; 
            this.costo = 2;
        } else if ("metralleta".equals(n)){
            this.nombre = "metralleta"; 
            this.ataque = 4; 
            this.costo = 4;
        } 
    }

    public String getNombre(){
        return nombre; 
    } 
    public int getAtaque() {
        return ataque; 
    }
    public int getCosto() {
        return costo; 
    }
}
