/**
 * Practica 3 del curso de Modelado y Programación
 * 
 * Clase Motor: deportivo, diesel, turbo.
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */

public class Motor {
    private String nombre;
    private int velocidad, costo; 
    
    public Motor(String n) {
        if ("deportivo".equals(n)) {
            this.nombre = "deportivo";  
            this.velocidad = 4; 
            this.costo = 3;
        } else if ("diesel".equals(n)){
            this.nombre = "diesel"; 
            this.velocidad = 3; 
            this.costo = 2;
        } else if ("turbo".equals(n)){
            this.nombre = "turbo"; 
            this.velocidad = 5; 
            this.costo = 4;
        } 
    }

    public String getNombre(){
        return nombre; 
    } 
    public int getVelocidad() {
        return velocidad; 
    }
    public int getCosto() {
        return costo; 
    }
}
