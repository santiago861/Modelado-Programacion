
/* 
 * Motor: deportivo, diesel, turbo
 */
public class Motor {
    private String nombre;
    private int velocidad, costo; 
    
    public Motor(String n) {
        if (n == "deportivo") {
            this.nombre = "deportivo";  
            this.velocidad = 4; 
            this.costo = 3;
        } else if (n == "diesel"){
            this.nombre = "diesel"; 
            this.velocidad = 3; 
            this.costo = 2;
        } else if (n == "turbo"){
            this.nombre = "turbo"; 
            this.velocidad = 5; 
            this.costo = 4;
        } 
    }
}
