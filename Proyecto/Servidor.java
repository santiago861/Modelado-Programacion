/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Servidor {
    static Map<String, DataOutputStream> connectedUsers = new HashMap<>();

    public static void main(String[] args) {
        int port = 7400;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando una conexión en el puerto " + port + "...");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Conexión establecida desde " + socketCliente.getInetAddress() + ":" + socketCliente.getPort());

                // Crea un nuevo hilo para manejar la conexión del cliente
                Thread clientHandlerThread = new Thread(new ClienteHandler(socketCliente));
                clientHandlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClienteHandler implements Runnable {
        private Socket socketCliente;
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;

        public ClienteHandler(Socket socketCliente) {
            this.socketCliente = socketCliente;
        }

        @Override
        public void run() {
            try {
                dataInputStream = new DataInputStream(socketCliente.getInputStream());
                dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());

                String nombreUsuario = dataInputStream.readUTF();
                connectedUsers.put(nombreUsuario, dataOutputStream);

                while (true) {
                    String[] mensajeParts = dataInputStream.readUTF().split(";");
                    String opcion = mensajeParts[0];

                    switch (opcion) {
                        case "1":
                            int tipoMensaje = Integer.parseInt(mensajeParts[1]);
                            String estado = mensajeParts[2];
                            String destinatario = mensajeParts[3];
                            String mensaje = mensajeParts[4];

                            if (tipoMensaje == 1) {
                                enviarMensajePublico(nombreUsuario, mensaje);
                            } else if (tipoMensaje == 2) {
                                enviarMensajePrivado(nombreUsuario, destinatario, mensaje);
                            }

                            dataOutputStream.writeUTF("Mensaje recibido con éxito");
                            dataOutputStream.flush();
                            break;

                        case "2":
                            enviarListaUsuarios();
                            break;

                        default:
                            System.out.println("Opción no válida del cliente " + nombreUsuario);
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dataInputStream != null) dataInputStream.close();
                    if (dataOutputStream != null) dataOutputStream.close();
                    if (socketCliente != null) socketCliente.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void enviarMensajePublico(String remitente, String mensaje) {
            for (Map.Entry<String, DataOutputStream> entry : connectedUsers.entrySet()) {
                String usuario = entry.getKey();
                DataOutputStream outputStream = entry.getValue();

                try {
                    outputStream.writeUTF("Mensaje público de " + remitente + ": " + mensaje);
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void enviarMensajePrivado(String remitente, String destinatario, String mensaje) {
            if (connectedUsers.containsKey(destinatario)) {
                DataOutputStream destinatarioOutputStream = connectedUsers.get(destinatario);

                try {
                    destinatarioOutputStream.writeUTF("Mensaje privado de " + remitente + ": " + mensaje);
                    destinatarioOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    dataOutputStream.writeUTF("El destinatario '" + destinatario + "' no está en la lista de usuarios conectados.");
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void enviarListaUsuarios() {
            StringBuilder listaUsuarios = new StringBuilder("Lista de usuarios conectados:\n");
            for (String usuario : connectedUsers.keySet()) {
                listaUsuarios.append(usuario).append("\n");
            }

            try {
                dataOutputStream.writeUTF(listaUsuarios.toString());
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}