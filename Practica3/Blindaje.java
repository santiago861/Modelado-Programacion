
/*
 * Blindaje: simple, reforzado, tanque
 */
public class Blindaje {
    private String name;
    private int defense, cost; 
    
    public Blindaje(String n) {
        if (n == "simple") {
            this.name = "simple";  
            this.defense = 3; 
            this.cost = 2;
        } else if (n == "reforzado"){
            this.name = "reforzado"; 
            this.defense = 5; 
            this.cost = 4;
        } else if (n == "tanque"){
            this.name = "tanque"; 
            this.defense = 2; 
            this.cost = 4;
        } 
    }
}
