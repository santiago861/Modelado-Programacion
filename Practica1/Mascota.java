/**
 * Practica 1 del curso de Modelado y Programación
 * 
 * La clase Mascota representa a una mascota con atributos como nombre, edad, especie, 
 * recuerdo, sexo, una lista de recuerdos y la posibilidad de tener un mejor amigo. 
 * Además, permite interactuar con las mascotas a través de distintas acciones. 
 * 
 * @author Santiago Iván Reyes Medina - 320308598
 * @author Carlos Yañez Diaz - 320032343
 * @version Versión 1
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner; 


public class Mascota {

    /** Nombre de la mascota */
    private String nombre;
    /** Edad de la mascota */
    public int edad;
    /** Especie de la mascota */
    final String especie = "Perro";
    /** Recuerdo de su propio dueño de la mascota */
    private String recuerdo;
    /** Sexo de la mascota */
    public String sexo; 
    /** Lista que guarda los recuerdos de la mascota sobre los dueños de otras mascotas */
    List<String> recuerdos = new ArrayList<>();
    /** Mejor amigo de la mascota */
    public String mejorAmingo;

    private static int instanceCount = 0; 

    /**
     * Construye una nueva mascota con sus parámetros
     * @param nombre Nombre de la mascota
     * @param edad Edad de la mascota
     * @param recuerdo Recuerdo de la mascota sobre su dueño
     * @param sexo Sexo de la mascota
     */
    public Mascota(String nombre, int edad, String recuerdo, String sexo) {
        this.nombre = nombre;
        this.edad = edad; 
        this.recuerdo = recuerdo;
        this.sexo = sexo;

        instanceCount++;
    }

    /**
     * Construye una nueva mascota con valores predeterminados
     */
    public Mascota() {
        nombre = "Toby";
        edad = 3; 
        sexo = "Macho";
    }

    /**
     * Permite acceder al mejor amigo de la mascota
     * @return el mejor amigo de la mascota
     */
    public String getMejorAmigo() {
        return mejorAmingo;
    }

    /**
     * Permite acceder al nombre de la mascota
     * @return el nombre de la mascota
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * Modifica el nombre de la mascota
     * @param n el nuevo nombre de la mascota
     */
    public void setNombre(String n) {
        this.nombre = n;
    }

    /** Accede a la edad de la mascota
     * @return la edad de la mascota
     */
    public int getEdad() {
        return edad;
    }

    /** Modifica la edad de la mascota
     * @param e la nueva edad de la mascota
     */
    public void setEdad(int e) {
        this.edad = e;
    }

    /** Accede a la especie de la mascota
     * @return la especie de la mascota
     */
    public String getEspecie() {
        return especie;
    }

    /** Accede al sexo de la mascota
     * @return el sexo de la mascota
     */
    public String getSexo() {
        return sexo;
    }

    /** Modifica el sexo de la mascota
     * @param s nuevo valor para atributo sexo de la mascota
     */
    public void setSexo(String s) {
        this.sexo = s;
    }

    /** Accede al recuerdo propio de la mascota sobre su dueño
     * @return recuerdo de su dueño
     */
    public String getRecuerdo() {
        return recuerdo;
    }

    /** Modifica el recuerdo que la mascota tiene sobre su dueño
     * @param r nuevo recuerdo de la mascota sobre su dueño
     */
    public void setRecuerdo(String r) {
        this.recuerdo = r;
    }

    /** Accede a la lista de recuerdos que tiene una mascota
     * @return lista de recuerdos
     */
    public List<String> getRecuerdos() {
        return recuerdos;
    }

    /** Accede al numero de instancias creadas de la clase Mascota
     * @return numero de instancias de mascota
     */
    public static int getInstanceCount() {
        return instanceCount;
    }



    /** Metodo que permite que una mascota a comparta el recuerdo que tiene sobre su dueño con una mascota b
     * @param a mascota que contara su recuerdo 
     * @param b mascota que escuchara su recuerdo
     * @param recuerdo_a recuerdo que sera contado
     */
    public static void comparteRecuerdo(Mascota a, Mascota b, String recuerdo_a) {
        if(b.recuerdos.size() >= 3) {
            System.out.println("La mascota de nombre " + b.getNombre() + " ya tiene recuerdos de tres mascotas diferentes");
        } else {
            b.recuerdos.add(recuerdo_a);
        }
    }

    @Override
    public String toString() {
        if(mejorAmingo == null) {
            this.mejorAmingo = "Esta mascota no tiene mejor amigo aun";
        }
        String cadena = "Nombre: " + this.getNombre() + ", Edad: " + this.getEdad() + ", Sexo: " + this.getSexo() + ", Recuerdo: " + this.getRecuerdo() + ", Mejor Amigo: " + this.getMejorAmigo() + ", Recuerdos: " + this.getRecuerdos();
        return cadena;
        
    }

    /** metodo que permite validar una seleccion entre un intervalo de numeros
     * @param numeroOpciones numero maximo en las opciones
     * @return numero seleccionado por el usuario
     */
    public static int seleccion(int numeroOpciones) {
        Scanner scanner = new Scanner(System.in);
        int s = 0;

        do {
            try {
                System.out.println("Ingrese una opcion valida");
                s = scanner.nextInt();
                if(s < 1 || s > numeroOpciones) {
                    System.out.println("La posicion ingresada es invalida");
                }
            } catch(InputMismatchException e) {
                String entradaInvalida = scanner.next();
                System.out.println("'" + entradaInvalida + "' es una entrada invalida, intentelo nuevamente...");
            }
        } while (s < 1 || s > numeroOpciones);
        // scanner.close();
        return s;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int accion = 0;
        boolean programa = true;

        Mascota mascota1 = new Mascota("Rayo", 3, "Mi dueño me adoptó cuando tenía dos años", "Macho");
        Mascota mascota2 = new Mascota("Luna", 1, "Mi dueño me saca a pasear todas las mañanas", "Hembra");
        Mascota mascota3 = new Mascota("Max", 4, "Mi dueño siempre me lleva al veterinario", "Macho");
        Mascota mascota4 = new Mascota("Rocco", 7, "Mi dueño y yo siempre corremos por la playa los sábados por la mañana", "Macho");
        Mascota mascota5 = new Mascota("Nala", 3, "Mi dueño siempre me prepara comidas distintas", "Hembra");
        Mascota mascota6 = new Mascota("Vito", 2, "Mi dueño siempre me compra juguetes nuevos", "Macho");

        Veterinario veterinario = new Veterinario("Dr. Pet");

        List<Mascota> listaMascotas = new ArrayList<>();
        listaMascotas.add(mascota1);
        listaMascotas.add(mascota2);
        listaMascotas.add(mascota3);
        listaMascotas.add(mascota4);
        listaMascotas.add(mascota5);
        listaMascotas.add(mascota6);

        do {
            System.out.println("Ingrese la accion que quiere realizar:\n" + "1: Mostrar lista de mascotas   2: Relacionar mascotas, 3: Terminar programa , 4: Hacer mejores amigos a dos mascotas");


            do {
                try {
                    System.out.println("Ingrese una opcion valida");
                    accion = scanner.nextInt();
                    if (accion > 4 || accion < 1) {
                        System.out.println("La accion que ingreso el usuario es invalida");
                    }
                } catch (InputMismatchException e) {
                    String accionInvalida = scanner.next();
                    System.out.println("'" + accionInvalida + "' no es una entrada valida, intentalo nuevamente");
                }
            } while (accion < 1 || accion > 4);


            if (accion == 1) {
                System.out.println("Ha elegido la opcion 1: Mostrar lista de mascotas");
                for (Mascota m : listaMascotas) {
                    System.out.println(m.toString() +  "\n");
                }
            } else if (accion == 2) {
                int i = 1;
                int indice1; 
                int indice2;
                Mascota mascota_1; 
                Mascota mascota_2; 

                System.out.println("Seleccione el numero de mascota que quiere contar su recuerdo: \n");
                for(Mascota m : listaMascotas) {
                    System.out.println("Mascota " + i + ": " + m);
                    i++;
                }
                indice1 = seleccion(listaMascotas.size());
                mascota_1 = listaMascotas.get(indice1 - 1);
                listaMascotas.remove(indice1 - 1);

                System.out.println("Seleccione el numero de mascota a la que le quiere contar su recuerdo: \n");
                i = 1; 
                for(Mascota m : listaMascotas) {
                    System.out.println("Macota " + i + ": " + m);
                    i++;
                }
                listaMascotas.add(mascota_1);
                indice2 = seleccion(listaMascotas.size() - 1);
                mascota_2 = listaMascotas.get(indice2 - 1);

                comparteRecuerdo(mascota_1, mascota_2, mascota_1.getRecuerdo());


            } else if (accion == 3) {
                System.out.println("Terminando ejecucion del programa");
                programa = false;
            } else if(accion == 4) {
                System.out.println("Seleccione la primera mascota");
                
                int i = 1;
                for(Mascota m : listaMascotas) {
                    System.out.println("Mascota " + i + ": " + m.getNombre());
                    i++;
                }

                int numMascotaA = seleccion(listaMascotas.size());

                System.out.println("Seleccione la segunda mascota");

                i = 1;
                for (Mascota m : listaMascotas) {
                    if(i != numMascotaA) {
                        System.out.println("Mascota " + i + ": " + m.getNombre());
                    }
                    i++;
                }

                int numMascotaB = seleccion(listaMascotas.size()); //* */
                
                Mascota mascotaA = listaMascotas.get(numMascotaA - 1);
                Mascota mascotaB = listaMascotas.get(numMascotaB - 1);

                veterinario.hacerMejoresAmigos(mascotaA, mascotaB);
            }
        } while (programa == true);

        System.out.println("Numero de instancias de la clase mascota creadas: " + Mascota.getInstanceCount());
        
        scanner.close();
    } 
}