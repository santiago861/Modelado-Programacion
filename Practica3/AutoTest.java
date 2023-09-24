import java.util.Scanner;
public class AutoTest{

  
    public static void main (String []args){
        Scanner entrada = new Scanner(System.in);
        int op;

        do {
            int puntosIniciales = 13; 
            System.out.println("--------------Fabrica de Autos-----------------");
            System.out.println("| 1. Crea tu propio carro                     |");
            System.out.println("| 2. Escoger un carro predeterminado          |");
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
                    System.out.println("Usted dispone de " + puntosIniciales + " puntos");
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
                    
                    boolean entradaCorrecta; 
                    do {
                        entradaCorrecta = true;
                        System.out.println("Considerando el precio en puntos del nuevo auto, ¿desea comprarlo?. Introduzca el numero entero para confirmar su decision \n");
                        System.out.println("1. SI");
                        System.out.println("2. NO");

                        String respuesta = entrada.next();
                        if (respuesta.equals("1")) {
                            if (puntosIniciales < nuevAuto.getCostoTotal()) {
                                System.out.println("No cuentas con los puntos sufiecientes para realizar la compra");
                            } else if (puntosIniciales >= nuevAuto.getCostoTotal()) {
                                System.out.println("Compra realizada con exito");
                            }
                        } else if (respuesta.equals("2")) {
                            System.out.println("La compra fue cancelada con exito");
                        } else {
                            System.out.println("La opcion proporcionada es incorrecta, ingrese una opcion valida por favor...");
                            entradaCorrecta = false;
                        }

                    } while (entradaCorrecta == false); 
                    

                } catch (Exception e) {
                    System.out.println("Ocurrio un error durante la creacion de tu auto");
                }

                break;

                case 2:
                System.out.println("Escoge entre uno de los siguientes tres carros (Ingresa unicamente el numero): \n");
                System.out.println("1. El carro con arpones como arma principal, blindaje simple, carroceria de camion, llantas de tipo off-road y motor deportivo");
                System.out.println("2. El carro con un cañon como arma, blindaje de tanque, carroceria deportiva, llantas tipo oruga y motor diesel");
                System.out.println("3. El carro con una sierra como arma, blindaje reforzado, carroceria casual, llantas simples y motor turbo");
                
                boolean entradaCorrecta; 
                    do {
                        entradaCorrecta = true;
                        String respuesta = entrada.next();

                        if (respuesta.equals("1")) {
                            Llantas llantas = AutoFactory.crearLlantas("off-road");
                            Blindaje blindaje = AutoFactory.crearBlindaje("simple");
                            Carroceria carroceria = AutoFactory.crearCarroceria("camion");
                            Armas armas = AutoFactory.crearArmas("arpones");
                            Motor motor = AutoFactory.crearMotor("deportivo");

                            Auto auto1 = AutoFactory.crearAuto(llantas, motor, carroceria, blindaje, armas);
                            System.out.println(auto1.toString());

                        } else if (respuesta.equals("2")) {
                            Llantas llantas = AutoFactory.crearLlantas("oruga");
                            Blindaje blindaje = AutoFactory.crearBlindaje("tanque");
                            Carroceria carroceria = AutoFactory.crearCarroceria("deportiva");
                            Armas armas = AutoFactory.crearArmas("cañones");
                            Motor motor = AutoFactory.crearMotor("diesel");

                            Auto auto2 = AutoFactory.crearAuto(llantas, motor, carroceria, blindaje, armas);
                            System.out.println(auto2.toString());

                        } else if (respuesta.equals("3")) {
                            Llantas llantas = AutoFactory.crearLlantas("simple");
                            Blindaje blindaje = AutoFactory.crearBlindaje("reforzado");
                            Carroceria carroceria = AutoFactory.crearCarroceria("casual");
                            Armas armas = AutoFactory.crearArmas("sierra");
                            Motor motor = AutoFactory.crearMotor("turbo");

                            Auto auto3 = AutoFactory.crearAuto(llantas, motor, carroceria, blindaje, armas);
                            System.out.println(auto3.toString());

                        } else {
                            System.out.println("La opcion proporcionada es incorrecta, ingrese una opcion valida ('1', '2' o '3')");
                            entradaCorrecta = false;
                        }

                    } while (entradaCorrecta == false); 
                
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