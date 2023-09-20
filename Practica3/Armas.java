
/*
 * Armas: arpones, lanzallamas, cañones, sierra, metralleta
 */
public class Armas {
    private String name;
    private int attack, cost; 
    
    public Armas(String n) {
        if (n == "arpones") {
            this.name = "arpones";  
            this.attack = 3; 
            this.cost = 2;
        } else if (n == "lanzallamas"){
            this.name = "lanzallamas"; 
            this.attack = 5; 
            this.cost = 4;
        } else if (n == "cañones"){
            this.name = "cañones"; 
            this.attack = 2; 
            this.cost = 4;
        } else if (n == "sierra"){
            this.name = "sierra"; 
            this.attack = 5; 
            this.cost = 4;
        } else if (n == "metralleta"){
            this.name = "metralleta"; 
            this.attack = 2; 
            this.cost = 4;
        } 
    }
}
