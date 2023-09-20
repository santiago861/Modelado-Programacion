
/*
 * Armas: arpones, lanzallamas, cañones, sierra, metralleta
 */
public class Armas {
    private String nombre;
    private int ataque, costo; 
    
    public Armas(String n) {
        if (n == "arpones") {
            this.nombre = "arpones";  
            this.ataque = 2; 
            this.costo = 2;
        } else if (n == "lanzallamas"){
            this.nombre = "lanzallamas"; 
            this.ataque = 3; 
            this.costo = 3;
        } else if (n == "cañones"){
            this.nombre = "cañones"; 
            this.ataque = 3; 
            this.costo = 2;
        } else if (n == "sierra"){
            this.nombre = "sierra"; 
            this.ataque = 3; 
            this.costo = 2;
        } else if (n == "metralleta"){
            this.nombre = "metralleta"; 
            this.ataque = 4; 
            this.costo = 4;
        } 
    }
}
