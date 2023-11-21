/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */


 import java.io.BufferedReader;
 import java.io.DataInputStream;
 import java.io.DataOutputStream;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.net.Socket;
 
 public class Cliente {
     public static void main(String[] args) {
         String serverHost = "127.0.0.1";
         int serverPort = 7400;
         Socket socket = null;
         DataInputStream dataInputStream = null;
         DataOutputStream dataOutputStream = null;
 
         try {
             socket = new Socket(serverHost, serverPort);
             System.out.println("Conectado al servidor...");
             dataInputStream = new DataInputStream(socket.getInputStream());
             dataOutputStream = new DataOutputStream(socket.getOutputStream());
 
             System.out.println("Ingresa tu nombre de usuario para entrar al servidor: ");
             String nombreUsuario = new BufferedReader(new InputStreamReader(System.in)).readLine();
             dataOutputStream.writeUTF(nombreUsuario);
 
             while (true) {
                 System.out.println("¿Qué deseas hacer?");
                 System.out.println("1. Enviar mensaje");
                 System.out.println("2. Ver lista de usuarios conectados");
                 System.out.println("3. Salir");
 
                 int opcion = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
 
                 switch (opcion) {
                     case 1:
                         System.out.println("Ingresa el tipo de mensaje: ");
                         System.out.println("1. Publico ");
                         System.out.println("2. Privado ");
 
                         int tipoMensaje = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                         String destinatario = "";
 
                         switch (tipoMensaje) {
                             case 1:
                                 // Mensaje público
                                 destinatario = ""; // Destinatario vacío para mensajes públicos
                                 break;
 
                             case 2:
                                 // Mensaje privado
                                 System.out.println("Ingresa el destinatario: ");
                                 destinatario = new BufferedReader(new InputStreamReader(System.in)).readLine();
                                 break;
 
                             default:
                                 System.out.println("Opción no válida. Por favor, selecciona nuevamente.");
                                 continue;
                         }
 
                         System.out.println("Ingresa tu estado: ");
                         System.out.println("1. Active ");
                         System.out.println("2. Away ");
                         System.out.println("3. Busy ");
 
                         int opcionEstado = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                         String estado;
 
                         switch (opcionEstado) {
                             case 1:
                                 estado = "Active";
                                 break;
 
                             case 2:
                                 estado = "Away";
                                 break;
 
                             case 3:
                                 estado = "Busy";
                                 break;
 
                             default:
                                 System.out.println("Opción no válida. Por favor, selecciona nuevamente.");
                                 continue;
                         }
 
                         System.out.println("Escribe tu mensaje: ");
                         String mensaje = new BufferedReader(new InputStreamReader(System.in)).readLine();
 
                         // Enviar datos al servidor
                         dataOutputStream.writeUTF("1;" + tipoMensaje + ";" + estado + ";" + destinatario + ";" + mensaje);
                         dataOutputStream.flush();
                         break;
 
                     case 2:
                         // Enviar solicitud al servidor para obtener la lista de usuarios conectados
                         dataOutputStream.writeUTF("2");
                         dataOutputStream.flush();
 
                         // Recibir y mostrar la lista de usuarios desde el servidor
                         String listaUsuarios = dataInputStream.readUTF();
                         System.out.println("Lista de usuarios conectados:\n" + listaUsuarios);
                         break;
 
                     case 3:
                         // Salir del programa
                         System.exit(0);
 
                     default:
                         System.out.println("Opción no válida. Por favor, selecciona nuevamente.");
                         break;
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (dataOutputStream != null) dataOutputStream.close();
                 if (dataInputStream != null) dataInputStream.close();
                 if (socket != null) socket.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
 }