import java.util.Scanner;

public class NotificacionTest{
    public static void main (String[] args){ 
        Scanner entrada = new Scanner(System.in);
        int op;

        do { 
            System.out.println("");
            System.out.println("Sistema de Notificación");
            System.out.println("");
            System.out.println("1. Envia notificacion SMS");
            System.out.println("2. Enviar notificacion Gmail");
            System.out.println("3. Enviar notificacion Facebook");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            op = entrada.nextInt();

            switch (op){
                case 1:
                System.out.println("");
                System.out.println("Notificacion SMS");
                System.out.println("");
                System.out.println("Escribe el numero al que deseas mandarle una notificacion: ");
                String destinatarioS = entrada.next();
                System.out.println("");
                System.out.println("Escribe tu mensaje");
                String mensajeS = entrada.next();
                Notificacion notificacion = new NotificacionSMS(new NotificacionBase());
                System.out.println("");
                notificacion.mensaje(mensajeS);
                System.out.println("");
                notificacion.destinatario(destinatarioS);
                    break;

                case 2:
                System.out.println("");
                System.out.println("Notificacion Gmail");
                System.out.println("");
                System.out.println("Escribe el correo al que deseas mandarle una notificacion: ");
                String destinatarioG = entrada.next();
                System.out.println("");
                System.out.println("Escribe tu mensaje");
                String mensajeG = entrada.next();
                Notificacion notificacionG = new NotificacionGmail(new NotificacionBase());
                System.out.println("");
                notificacionG.mensaje(mensajeG);
                System.out.println("");
                notificacionG.destinatario(destinatarioG);
                    break;

                case 3:
                System.out.println("");
                System.out.println("Notificacion Facebook");
                System.out.println("");
                System.out.println("Escribe el usuario al que deseeas mandarle una notificacion: ");
                String destinatarioF = entrada.next();
                System.out.println("");
                System.out.println("Escribe tu mensaje");
                String mensajeF = entrada.next();
                Notificacion notificacionF = new NotificacionFacebook(new NotificacionBase());
                System.out.println("");
                notificacionF.mensaje(mensajeF);
                System.out.println("");
                notificacionF.destinatario(destinatarioF);
                    break; 

                case 4:
                    System.out.println("Saliendo del programa...");
                        break;

                default:
                System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                    break;
            }
        } while(op != 4);

        entrada.close(); 
    }
}
    
