/**
 * Practica 1 del curso de Modelado y Programación
 * 
 * La clase veterinario representa un veterinario el cual es capaz de hacer que dos mascotas se vuelvan mejores amigos y deshacer amistades
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */
 
public class Veterinario{
    public String name; 


    /** Construye un veterinario con sus atributos
     * @param name nombre del veterinario 
     */
    public Veterinario(String name) {
        this.name = name;
    }

    /** Accede al nombre del veterinario 
     * @return nombre del veterinario 
     */
    public String getName() {
        return name;
    }

    /** Metodo que nos permite relacionar como mejores amigos a dos mascotas seleccionadas por el usuario
     * @param mascotaA mascota que sera mejor amiga de mascota B
     * @param mascotaB mascota que sera mejor amiga de mascota A
     */
    public void hacerMejoresAmigos(Mascota mascotaA, Mascota mascotaB) {
        mascotaA.mejorAmingo = mascotaB.getNombre();
        mascotaB.mejorAmingo = mascotaA.getNombre();

        System.out.println("Ahora el mejor amigo de " + mascotaA.getNombre() + " es " + mascotaB.getNombre() + " y el mejor amigo de " + mascotaB.getNombre() + " es " + mascotaA.getNombre());
    }

}
