/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageBlend {
    public static void main(String[] args) {
        try {
            // Rutas de las imágenes que deseas combinar
            String imagePath1 = "imagen1.png";
            String imagePath2 = "imagen2.png";

            // Cargar las imágenes
            BufferedImage image1 = ImageIO.read(new File(imagePath1));
            BufferedImage image2 = ImageIO.read(new File(imagePath2));

            // Comprobar que las imágenes tengan las mismas dimensiones
            if (image1.getWidth() != image2.getWidth() || image1.getHeight() != image2.getHeight()) {
                System.out.println("Las imágenes no tienen las mismas dimensiones. Deben ser del mismo tamaño.");
                return;
            }

            // Tasa de mezcla (50% en este caso)
            float alpha = 0.5f;

            // Ancho y alto de las imágenes
            int width = image1.getWidth();
            int height = image1.getHeight();

            // Crear una nueva imagen para el resultado
            BufferedImage blendedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Realizar el "blend" al 50%
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb1 = image1.getRGB(x, y);
                    int rgb2 = image2.getRGB(x, y);

                    int blendedRGB = blendColors(rgb1, rgb2, alpha);

                    blendedImage.setRGB(x, y, blendedRGB);
                }
            }

            // Guardar la imagen resultante en formato JPEG
            String outputImagePath = "imagen_blend.png";
            System.out.println("Guardando la imagen en: " + new File(outputImagePath).getAbsolutePath());
            ImageIO.write(blendedImage, "png", new File(outputImagePath));


            System.out.println("Mezcla completada. La imagen resultante se ha guardado en " + outputImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Función para mezclar colores con la tasa alpha
    /**
     * Mezcla dos colores dados en una proporción determinada por el valor alpha.
     *
     * @param color1 El primer color a mezclar, representado como un entero ARGB.
     * @param color2 El segundo color a mezclar, representado como un entero ARGB.
     * @param alpha El valor de tasa de mezcla, donde 0.0 significa que se usará
     *              completamente el color1, 1.0 significa que se usará completamente
     *              el color2 y 0.5 significa una mezcla al 50% de ambos colores.
     * @return El color resultante después de la mezcla.
     */
    private static int blendColors(int color1, int color2, float alpha) {
        // Separar los componentes de color (rojo, verde y azul) del color1
        int red1 = (color1 >> 16) & 0xFF;
        int green1 = (color1 >> 8) & 0xFF;
        int blue1 = color1 & 0xFF;

        // Separar los componentes de color (rojo, verde y azul) del color2
        int red2 = (color2 >> 16) & 0xFF;
        int green2 = (color2 >> 8) & 0xFF;
        int blue2 = color2 & 0xFF;

        // Calcular el color mezclado en base al valor alpha
        int blendedRed = (int) (red1 * (1 - alpha) + red2 * alpha);
        int blendedGreen = (int) (green1 * (1 - alpha) + green2 * alpha);
        int blendedBlue = (int) (blue1 * (1 - alpha) + blue2 * alpha);

        // Combinar los componentes y devolver el color mezclado como un entero ARGB
        return (blendedRed << 16) | (blendedGreen << 8) | blendedBlue;
    }
}
