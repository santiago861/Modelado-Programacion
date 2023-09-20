
/* 
 * Motor: deportivo, diesel, turbo
 */
public class Motor {
    private String name;
    private int speed, cost; 
    
    public Motor(String n) {
        if (n == "deportivo") {
            this.name = "deportivo";  
            this.speed = 3; 
            this.cost = 2;
        } else if (n == "diesel"){
            this.name = "diesel"; 
            this.speed = 5; 
            this.cost = 4;
        } else if (n == "turbo"){
            this.name = "turbo"; 
            this.speed = 2; 
            this.cost = 4;
        } 
    }
}
