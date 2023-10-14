import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class NotificacionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Notificacion> notificaciones = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("Sistema de Notificación");
            System.out.println("1. Configurar preferencias de notificación");
            System.out.println("2. Enviar notificación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Configurar preferencias de notificación (seleccionar tipo de notificación).
                    System.out.println("Seleccione el tipo de notificación:");
                    System.out.println("1. Correo Electrónico");
                    System.out.println("2. SMS");
                    System.out.println("3. Notificación Push");
                    int tipoNotificacion = scanner.nextInt();

                    System.out.print("Mensaje: ");
                    String mensaje = scanner.next();

                    switch (tipoNotificacion) {
                        case 1:
                            System.out.print("Email destinatario: ");
                            String emailDestino = scanner.next();
                            notificaciones.add(new NotificacionEmail(mensaje, emailDestino));
                            break;
                        case 2:
                            System.out.print("Número de teléfono: ");
                            String numeroTelefono = scanner.next();
                            notificaciones.add(new NotificacionSMS(mensaje, numeroTelefono));
                            break;
                        case 3:
                            System.out.println("Usuario destinatario: ");
                            String usuarioDestino = scanner.next();
                            notificaciones.add(new NotificacionPush(mensaje, usuarioDestino));
                            break;
                        default:
                            System.out.println("Tipo de notificación no válido.");
                            break;
                    }
                    break;

                case 2:
                    // Enviar notificación.
                    System.out.println("Notificaciones disponibles:");
                    for (int i = 0; i < notificaciones.size(); i++) {
                        System.out.println(i + 1 + ". " + notificaciones.get(i).getClass().getSimpleName());
                    }
                    System.out.print("Seleccione una notificación para enviar: ");
                    int selectedNotification = scanner.nextInt();
                    if (selectedNotification >= 1 && selectedNotification <= notificaciones.size()) {
                        notificaciones.get(selectedNotification - 1).enviar();
                    } else {
                        System.out.println("Notificación no válida.");
                    }
                    break;

                case 3:
                    running = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
