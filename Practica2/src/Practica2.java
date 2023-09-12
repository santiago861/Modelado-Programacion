import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;

/**
 *
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */
public class Practica2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        BufferedImage i = null;
        int p;

        /* Este bloque de codigo va a leer la imagen foto.jpg si esta existe en la ruta especificada, de lo contrario
         * lanzara un mensaje de error
         */
        try{
            File imageFile = new File("imagenes/foto.jpg"); 
            if (imageFile.exists()) {
                i = ImageIO.read(imageFile);
            } else {
                System.err.println("El archivo de imagen no se encontró...");
            }
        } catch (Exception e){
            System.out.println("Se produjo un error al cargar la imagen introducida");
        }

        /* Este bloque de codigo crea una nuevas imagenes nI, nI2, nI3 y nI4 con las mismas caracteristicas de la imagen i, y 
         * las modifica pixel por pixel para aplicarles filtros (escala de grises, verde, rojo y tonos sepia respectivamente)
         * 
         * Utiliza ciclos anidados para recorrer pixel por pixel las imagenes y les asigna nuevos valores rgb. Por ultimo guarda las imagenes 
         * creadas en nuevos archivos formato jpg en el directorio imagenes.
         */
        
        BufferedImage nI = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage nI2 = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage nI3 = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage nI4 = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Color c, c2, c3, c4;
        int c1, c2a, c3a, c11, c22, c33;

        for (int w = 0; w < i.getHeight(); w++) {
            for (int z = 0; z < i.getWidth(); z++) {
                c = new Color(i.getRGB(z, w));
                c2 = new Color(i.getRGB(z, w));
                c3 = new Color(i.getRGB(z, w));
                c4 = new Color(i.getRGB(z, w));
                p = (c.getRed() + c.getGreen() + c.getBlue()) / 3;

                // el siguiente codigo es para la modificacion de la imagen 4
                c1 = c4.getRed();
                c2a = c4.getGreen();
                c3a = c4.getBlue();

                c11 = (int) ((c1 * .393) + (c2a * .769) + (c3a * .189));
                c22 = (int) ((c1 * .349) + (c2a * .686) + (c3a * .168));
                c33 = (int) ((c1 * .272) + (c2a * .534) + (c3a * .131));

                c11 = (c11 > 255) ? 255 : (c11 < 0) ? 0 : c11; 
                c22 = (c22 > 255) ? 255 : (c22 < 0) ? 0 : c22; 
                c33 = (c33 > 255) ? 255 : (c33 < 0) ? 0 : c33; 


                // asignacion de los nuevos valores rgb a los pixeles en las respectivas imagenes
                nI.setRGB(z, w, new Color(p, p, p).getRGB());
                nI2.setRGB(z, w, new Color(c2.getRed(), 0, 0).getRGB());
                nI3.setRGB(z, w, new Color(0, c3.getGreen(), 0).getRGB());
                nI4.setRGB(z, w, new Color(c11, c22, c33).getRGB());
            }
        }
        
        /* 
         * Este codigo guarda la informacion de las imagenes creadas en archivos nuevos en formato jpg, si ocurre un error maneja la excepcion
         * de manera adecuada
         */
        try {
            ImageIO.write(nI, "jpg", new File("imagenes/i1.jpg"));
            System.out.println("La imagen nI se ha guardado correctamente en i1.jpg");
            
            ImageIO.write(nI2, "jpg", new File("imagenes/i2.jpg"));
            System.out.println("La imagen nI2 se ha guardado correctamente en i2.jpg");

            ImageIO.write(nI3, "jpg", new File("imagenes/i3.jpg"));
            System.out.println("La imagen nI3 se ha guardado correctamente en i3.jpg");

            ImageIO.write(nI4, "jpg", new File("imagenes/i4.jpg"));
            System.out.println("La imagen nI4 se ha guardado correctamente en i4.jpg");
        } catch (Exception e) {
            System.err.println("Ocurrio un error al intentar guardar la informacion de las imagenes creadas en los nuevos archivos");
        }
    }
}

