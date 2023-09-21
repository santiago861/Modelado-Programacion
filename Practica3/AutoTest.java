import java.util.Scanner;
public class AutoTest{

  
    public static void main (String []args){
        Scanner entrada = new Scanner(System.in);
        int op;
        do {
        System.out.println("--------------Fabrica de Autos-----------------");
        System.out.println("| 1. Crea tu propio carro                     |");
        System.out.println("| 2. Crea un carro al azar                    |");
        System.out.println("| 3. Sal del programa                         |");
        System.out.println("-----------------------------------------------");
        System.out.println("");
        System.out.println("Escoge una opcion del menu:");
            op = entrada.nextInt();

            switch (op){
                case 1:

                //Hacemos la seleccion de llantas al carro
                System.out.println("!Vamos a crear tu carro!");
                System.out.println("");
                System.out.println("Escribe el tipo de llanta que desees:");
                System.out.println("simple");
                System.out.println("deportivas");
                System.out.println("off-road");
                System.out.println("oruga");
                String llanta = entrada.next();
                Llantas tipollanta = new Llantas(llanta);

                //Hacemos la seleccion de motor al carro
                System.out.println("");
                System.out.println("Ahora escribe el tipo de motor que desees:");
                System.out.println("deportivo");
                System.out.println("diesel");
                System.out.println("turbo");
                String motor = entrada.next();
                Motor tipoMotor = new Motort(motor);

                //Hacemos la seleccion de motor al carro
                System.out.println("");
                System.out.println("Ahora escribe el tipo de carroseria que desees:");
                System.out.println("casual");
                System.out.println("camion");
                System.out.println("deportiva");
                String caroseria = entrada.next();
                Carroceria tipoCarroseria = new Carroceria(caroseria);

                //Hacemos la seleccion del blindaje al carro
                System.out.println("");
                System.out.println("Ahora escribe el tipo de blindaje que desees:");
                System.out.println("simple");
                System.out.println("reforzado");
                System.out.println("tanque");
                String blindaje = entrada.next();
                Blindaje tipoBlindaje = new Blindaje(blindaje);

                //Hacemos la seleccion del blindaje al carro
                System.out.println("");
                System.out.println("Ahora escribe el tipo de armas que desees:");
                System.out.println("arpones");
                System.out.println("lanzallamas");
                System.out.println("cañones");
                System.out.println("sierra");
                System.out.println("metralleta");
                String arma = entrada.next();
                Armas tipoArmas = new Armas(arma);

                //Creamos el auto
                System.out.println("");
                System.out.println("");
                System.out.println("Creando Auto...");
                Auto nuevAuto = new Auto(tipollanta, tipoMotor, tipoCarroseria, tipoBlindaje, tipoArmas);


                    break;

                case 2:
                //Por completar
                    break;

                case 3: 
                System.out.println("Saliendo del programa.");
                    break;

                default:
                System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                    break;
            }
        } while(op != 3);
    }
}