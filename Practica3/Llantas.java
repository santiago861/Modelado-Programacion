
/*
 * Llantas: simple, deportivas, off-road, oruga de tanque
 */
public class Llantas {
    private String name;
    private int speed, cost; 
    
    public Llantas(String n) {
        if (n == "simple") {
            this.name = "simple";  
            this.speed = 3; 
            this.cost = 2;
        } else if (n == "deportivas"){
            this.name = "deportivas"; 
            this.speed = 5; 
            this.cost = 4;
        } else if (n == "off-road"){
            this.name = "off-road"; 
            this.speed = 2; 
            this.cost = 4;
        } else if (n == "oruga"){
            this.name = "oruga";  
            this.speed = 1; 
            this.cost = 5;
        } 
    }
}
