import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */

public class Actividad2{
    public static void main(String[] args) {
        BufferedImage imagenOriginal = null;

        /* Este bloque de codigo va a leer la imagen foto.jpg si esta existe en la ruta especificada, de lo contrario
         * lanzara un mensaje de error
         */
        try {
            File archivoImagen = new File("Imagenes/cr7.jpg");
            if (archivoImagen.exists()) {
                imagenOriginal = ImageIO.read(archivoImagen);
            } else {
                System.err.println("El archivo de imagen no se encontró...");
                return;
            }
        } catch (IOException e) {
            System.err.println("Se produjo un error al cargar la imagen introducida: " + e.getMessage());
            return;
        }

        BufferedImage BW = new BufferedImage(imagenOriginal.getWidth(), imagenOriginal.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        int numHilos = 4; // Utilizaremos 4 hilos

        Thread[] hilos = new Thread[numHilos];


        /* 
         * Dividimos la imagen y los hilos cambiaran pixel por pixel el color
         */
        int alturaPorHilo = imagenOriginal.getHeight() / numHilos;
        for (int i = 0; i < numHilos; i++) {
            int filaInicio = i * alturaPorHilo;
            int filaFin = (i == numHilos - 1) ? imagenOriginal.getHeight() : (filaInicio + alturaPorHilo);
            hilos[i] = new HiloBW(imagenOriginal, BW, filaInicio, filaFin);
            hilos[i].start();
        }

        try {
            for (int i = 0; i < numHilos; i++) {
                hilos[i].join();
            }

            ImageIO.write(BW, "jpg", new File("Imagenes/cr7BW.jpg"));
            System.out.println("La imagen en escala de grises se ha guardado correctamente en cr7BW.jpg");
        } catch (IOException | InterruptedException e) {
            System.err.println("Ocurrió un error al intentar guardar la información de la imagen creada en escala de grises en el nuevo archivo cr7BW.jpg: " + e.getMessage());
        }
    }
}   
         /* 
         * Esta clase define los hilos que procesarán los distintos segmentos de la imagen en paralelo
         */
class HiloBW extends Thread {
    BufferedImage imagenOriginal;
    BufferedImage BW;
    int filaInicio, filaFin;

    public HiloBW(BufferedImage imagenOriginal, BufferedImage BW, int filaInicio, int filaFin) {
        this.imagenOriginal = imagenOriginal;
        this.BW = BW;
        this.filaInicio = filaInicio;
        this.filaFin = filaFin;
    }

    @Override
    public void run() {
        for (int y = filaInicio; y < filaFin; y++) {
            for (int x = 0; x < imagenOriginal.getWidth(); x++) {
                Color c = new Color(imagenOriginal.getRGB(x, y));
                int p = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                BW.setRGB(x, y, new Color(p, p, p).getRGB());
            }
        }
    }
}
