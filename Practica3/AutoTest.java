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

                try {
                    //Hacemos la seleccion de llantas al carro
                    System.out.println("!Vamos a crear tu carro!");
                    System.out.println("");
                    System.out.println("Escribe el tipo de llanta que desees:");
                    System.out.println("simple");
                    System.out.println("deportivas");
                    System.out.println("off-road");
                    System.out.println("oruga");
                    String llanta = entrada.next();
                    Llantas tipollanta = AutoFactory.crearLlantas(llanta);

                    //Hacemos la seleccion de motor al carro
                    System.out.println("");
                    System.out.println("Ahora escribe el tipo de motor que desees:");
                    System.out.println("deportivo");
                    System.out.println("diesel");
                    System.out.println("turbo");
                    String motor = entrada.next();
                    Motor tipoMotor = AutoFactory.crearMotor(motor);

                    //Hacemos la seleccion de motor al carro
                    System.out.println("");
                    System.out.println("Ahora escribe el tipo de carroseria que desees:");
                    System.out.println("casual");
                    System.out.println("camion");
                    System.out.println("deportiva");
                    String caroceria = entrada.next();
                    Carroceria tipoCarroceria = AutoFactory.crearCarroceria(caroceria);

                    //Hacemos la seleccion del blindaje al carro
                    System.out.println("");
                    System.out.println("Ahora escribe el tipo de blindaje que desees:");
                    System.out.println("simple");
                    System.out.println("reforzado");
                    System.out.println("tanque");
                    String blindaje = entrada.next();
                    Blindaje tipoBlindaje = AutoFactory.crearBlindaje(blindaje);

                    //Hacemos la seleccion del blindaje al carro
                    System.out.println("");
                    System.out.println("Ahora escribe el tipo de armas que desees:");
                    System.out.println("arpones");
                    System.out.println("lanzallamas");
                    System.out.println("cañones");
                    System.out.println("sierra");
                    System.out.println("metralleta");
                    String arma = entrada.next();
                    Armas tipoArmas = AutoFactory.crearArmas(arma);

                    //Creamos el auto
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Creando Auto...");
                    Auto nuevAuto = AutoFactory.crearAuto(tipollanta, tipoMotor, tipoCarroceria, tipoBlindaje, tipoArmas);

                    System.out.println(nuevAuto.toString());

                } catch (Exception e) {
                    System.out.println("Ocurrio un error durante la creacion de tu auto");
                }

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

        entrada.close();; 
    }
}