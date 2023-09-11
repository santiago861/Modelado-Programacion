import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;

/**
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

        /* Este bloque de codigo crea una nueva imagen nI con las mismas caracteristicas de la imagen i, y 
         * la modifica pixel por pixel para que nI ahora este en escala de grises.
         * 
         * Crea una nueva imagen nI exactamente con las mismas caracteristicas de i, utiliza ciclos anidados para recorrer pixel por 
         * pixel la imagen y asignarle un nuevo valor rgb en escalas de grises. Por ultimo guarda la imagen creada nI
         * en un nuevo archivo formato jpg llamado i1.jpg en el directorio imagenes.
         */
        
        BufferedImage nI = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Color c;
        for (int w = 0; w < i.getHeight(); w++) {
            for (int z = 0; z < i.getWidth(); z++) {
                c = new Color(i.getRGB(z, w));
                p = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                nI.setRGB(z, w, new Color(p, p, p).getRGB());
            }
        }

        try {
            ImageIO.write(nI, "jpg", new File("imagenes/i1.jpg"));
            System.out.println("La imagen nI se ha guardado correctamente en i1.jpg");
        } catch (Exception e) {
            System.err.println("Ocurrio un error al intentar guardar la informacion de la imagen creada nI en el nuevo archivo i1.jpg");
        }

        /* Este bloque de codigo crea una nueva imagen nI2 con las mismas caracteristicas de la imagen i, y 
         * la modifica pixel por pixel para que nI2 ahora este en escala de rojos. 
         * 
         * Crea una nueva imagen nI2 exactamente con las mismas caracteristicas de i, utiliza ciclos anidados para recorrer pixel por 
         * pixel la imagen y asignarle un nuevo valor rgb en escalas de rojos. Por ultimo guarda la imagen creada nI2
         * en un nuevo archivo formato jpg llamado i2.jpg en el directorio imagenes.
         */

        BufferedImage nI2 = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Color c2;
        for (int w = 0; w < i.getHeight(); w++) {
            for (int z = 0; z < i.getWidth(); z++) {
                c2 = new Color(i.getRGB(z, w));
                nI2.setRGB(z, w, new Color(c2.getRed(), 0, 0).getRGB());
            }
        }

        try {
            ImageIO.write(nI2, "jpg", new File("imagenes/i2.jpg"));
            System.out.println("La imagen nI2 se ha guardado correctamente en i2.jpg");
        } catch (Exception e) {
            System.err.println("Ocurrio un error al intentar guardar la informacion de la imagen creada nI2 en el nuevo archivo i2.jpg");
        }

        /* Este bloque de codigo crea una nueva imagen nI3 con las mismas caracteristicas de la imagen i, y 
         * la modifica pixel por pixel para que nI3 ahora este en escala de verdes. 
         * 
         * Crea una nueva imagen nI3 exactamente con las mismas caracteristicas de i, utiliza ciclos anidados para recorrer pixel por 
         * pixel la imagen y asignarle un nuevo valor rgb en escalas de verdes. Por ultimo guarda la imagen creada nI3
         * en un nuevo archivo formato jpg llamado i3.jpg en el directorio imagenes.
         */

        BufferedImage nI3 = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Color c3;
        for (int w = 0; w < i.getHeight(); w++) {
            for (int z = 0; z < i.getWidth(); z++) {
                c3 = new Color(i.getRGB(z, w));
                nI3.setRGB(z, w, new Color(0, c3.getGreen(), 0).getRGB());
            }
        }

        try {
            ImageIO.write(nI3, "jpg", new File("imagenes/i3.jpg"));
            System.out.println("La imagen nI3 se ha guardado correctamente en i3.jpg");
        } catch (Exception e) {
            System.err.println("Ocurrio un error al intentar guardar la informacion de la imagen creada nI3 en el nuevo archivo i3.jpg");
        }

        /* Este bloque de codigo crea una nueva imagen nI4 con las mismas caracteristicas de la imagen i, y 
         * la modifica pixel por pixel para que nI4 ahora este en tonos sepia. 
         * 
         * Crea una nueva imagen nI4 exactamente con las mismas caracteristicas de i, utiliza ciclos anidados para recorrer pixel por 
         * pixel la imagen y asignarle un nuevo valor rgb en tonos sepia. Por ultimo guarda la imagen creada nI4
         * en un nuevo archivo formato jpg llamado i4.jpg en el directorio imagenes.
         */

        BufferedImage nI4 = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Color c4;
        int c1, c2a, c3a, c11, c22, c33;

        for (int y = 0; y < i.getHeight(); y++) {
            for (int x = 0; x < i.getWidth(); x++) {

                c4 = new Color(i.getRGB(x, y));

                c1 = c4.getRed();
                c2a = c4.getGreen();
                c3a = c4.getBlue();

                /*
                * Este bloque de calculo se encarga multiplican los componentes originales de color (rojo, verde y azul)
                * por factores especificos y luego los suman para obtener los nuevos valores y asi obtener nuevos colores
                *
                * Los valores se almacenaron anteriormente como enteros y se asegura de que esten en el rango valido
                * de 0 a 255 para evitar desbordamientos o valores negativos.
                */

                c11 = (int) ((c1 * .393) + (c2a * .769) + (c3a * .189));
                c22 = (int) ((c1 * .349) + (c2a * .686) + (c3a * .168));
                c33 = (int) ((c1 * .272) + (c2a * .534) + (c3a * .131));

                c11 = (c11 > 255) ? 255 : (c11 < 0) ? 0 : c11; 
                c22 = (c22 > 255) ? 255 : (c22 < 0) ? 0 : c22; 
                c33 = (c33 > 255) ? 255 : (c33 < 0) ? 0 : c33; 

                nI4.setRGB(x, y, new Color(c11, c22, c33).getRGB());
            }
        }

        try {
            ImageIO.write(nI4, "jpg", new File("imagenes/i4.jpg"));
            System.out.println("La imagen nI4 se ha guardado correctamente en i4.jpg");
        } catch (Exception e) {
            System.err.println("Ocurrio un error al intentar guardar la informacion de la imagen creada nI4 en el nuevo archivo i4.jpg");
        }
    }
}

