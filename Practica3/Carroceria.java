
/*
 * Carrocerıa: casual, camion, deportiva
 */
public class Carroceria {
    private String name;
    private int defense, cost; 
    
    public Carroceria(String n) {
        if (n == "casual") {
            this.name = "casual";  
            this.defense = 3; 
            this.cost = 2;
        } else if (n == "camion"){
            this.name = "camion"; 
            this.defense = 5; 
            this.cost = 4;
        } else if (n == "deportiva"){
            this.name = "deportiva"; 
            this.defense = 2; 
            this.cost = 4;
        } 
    }
}
