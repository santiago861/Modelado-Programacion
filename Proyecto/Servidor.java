/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */


 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
 import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
 
 public class Cliente{
     static Scanner entrada = new Scanner(System.in);
     public static void main(String[] args) {
         String serverHost = "127.0.0.1";
         int serverPort = 7400; // Puerto del servidor
         Socket socket = null;
         BufferedReader msj = null;
         BufferedWriter out = null;
         String usuario;
         Servidor listaUsers = new Servidor();
         try {
             System.out.println("Ingresa tu nombre de usuario para entrar al servidor: ");
             usuario = entrada.next();
            /*while (listaUsers.getUsers().contains(usuario)){
                System.out.println("El nombre de usuario ya esta en uso, agrega otro: ");
                usuario = null;
                usuario = entrada.next();
            }*/
             listaUsers.agregaUsuario(usuario);
             socket = new Socket(serverHost, serverPort);
             System.out.println("Conectado al servidor...");
 
             msj = new BufferedReader(new InputStreamReader(System.in));
             out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
 
             String cliente;
 
             System.out.println("Escribe un mensaje (o 'salir' para salir):");
 
             while (true) {
                 cliente = msj.readLine();
                 if (cliente == null || cliente.equalsIgnoreCase("salir")) {
                     break; // Salir del bucle si el usuario escribe salir
                 }
                 out.write(cliente + "\n");
                 out.flush();
             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (out != null) out.close();
                 if (msj != null) msj.close();
                 if (socket != null) socket.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }
 }
