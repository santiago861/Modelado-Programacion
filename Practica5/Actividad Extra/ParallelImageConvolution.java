/**
 * @author Yanez Diaz Carlos
 * @author Reyes Medina Santiago Ivan
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;

public class ParallelImageConvolution {

    public static void main(String[] args) {
        try {
            // Cargamos una imagen de entrada desde un archivo llamado "imagen1.png".
            BufferedImage inputImage = ImageIO.read(new File("imagen1.png"));

            // Definimos el kernel de convolución.
            int[][] kernel = {
                {1, 0, -1},
                {2, 0, -2},
                {1, 0, -1}
            };

            // Aplicamos la convolución en paralelo a la imagen de entrada.
            BufferedImage outputImage = applyConvolutionParallel(inputImage, kernel);

            // Guardamos la imagen de salida en un archivo llamado "output_image.jpg".
            File outputImageFile = new File("output_image.jpg");
            ImageIO.write(outputImage, "jpg", outputImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Función para aplicar la convolución en paralelo a la imagen de entrada.
    public static BufferedImage applyConvolutionParallel(BufferedImage inputImage, int[][] kernel) {
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        // Creamos una nueva imagen de salida con el mismo tamaño que la imagen de entrada.
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Usamos Parallel Streams para paralelizar el procesamiento de las filas de la imagen.
        IntStream.range(0, height).parallel().forEach(y -> {
            for (int x = 0; x < width; x++) {
                // Aplicamos el kernel a cada píxel y actualizamos el píxel en la imagen de salida.
                int color = applyKernel(inputImage, x, y, kernel);
                outputImage.setRGB(x, y, color);
            }
        });

        return outputImage;
    }

    // Función para aplicar el kernel a un píxel de la imagen.
    public static int applyKernel(BufferedImage image, int x, int y, int[][] kernel) {
        int width = image.getWidth();
        int height = image.getHeight();
        int kernelSize = kernel.length;
        int halfKernelSize = kernelSize / 2;
        int[] rgbValues = new int[kernelSize * kernelSize];

        // Iteramos a través del kernel y los píxeles correspondientes en la imagen.
        for (int i = -halfKernelSize; i <= halfKernelSize; i++) {
            for (int j = -halfKernelSize; j <= halfKernelSize; j++) {
                // Calculamos las coordenadas del píxel en la imagen.
                int newX = Math.min(Math.max(x + j, 0), width - 1);
                int newY = Math.min(Math.max(y + i, 0), height - 1);
                // Obtenemos los valores RGB de los píxeles y los almacenamos en un arreglo.
                rgbValues[(i + halfKernelSize) * kernelSize + (j + halfKernelSize)] = image.getRGB(newX, newY);
            }
        }

        // Realizamos la convolución aplicando el kernel a los píxeles vecinos.
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < kernelSize * kernelSize; i++) {
            int color = rgbValues[i];
            int weight = kernel[i / kernelSize][i % kernelSize];
            red += ((color >> 16) & 0xFF) * weight;
            green += ((color >> 8) & 0xFF) * weight;
            blue += (color & 0xFF) * weight;
        }

        // Aseguramos que los valores estén en el rango [0, 255].
        red = Math.min(Math.max(red, 0), 255);
        green = Math.min(Math.max(green, 0), 255);
        blue = Math.min(Math.max(blue, 0), 255);

        // Combinamos los valores RGB y retornamos el color resultante.
        return (red << 16) | (green << 8) | blue;
    }
}