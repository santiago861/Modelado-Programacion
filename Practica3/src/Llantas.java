/**
 * Practica 3 del curso de Modelado y Programación
 * 
 * Clase Llantas: simple, deportivas, off-road, oruga de tanque.
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */

public class Llantas {
    private String nombre;
    private int velocidad, costo; 
    
    public Llantas(String n) {
        if ("simple".equals(n)) {
            this.nombre = "simple";  
            this.velocidad = 2; 
            this.costo = 2;
        } else if ("deportivas".equals(n)){
            this.nombre = "deportivas"; 
            this.velocidad = 5; 
            this.costo = 4;
        } else if ("off-road".equals(n)){
            this.nombre = "off-road"; 
            this.velocidad = 3; 
            this.costo = 3;
        } else if ("oruga".equals(n)){
            this.nombre = "oruga";  
            this.velocidad = 1; 
            this.costo = 3;
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
