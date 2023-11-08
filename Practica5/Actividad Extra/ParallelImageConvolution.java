import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;

public class ParallelImageConvolution {

    public static void main(String[] args) {
        try {
            BufferedImage inputImage = ImageIO.read(new File("imagen1.png"));
            int[][] kernel = {
                {1, 0, -1},
                {2, 0, -2},
                {1, 0, -1}
            };

            BufferedImage outputImage = applyConvolutionParallel(inputImage, kernel);

            // Guardar la imagen de salida
            File outputImageFile = new File("output_image.jpg");
            ImageIO.write(outputImage, "jpg", outputImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage applyConvolutionParallel(BufferedImage inputImage, int[][] kernel) {
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int parallelism = ForkJoinPool.getCommonPoolParallelism();

        IntStream.range(0, height).parallel().forEach(y -> {
            for (int x = 0; x < width; x++) {
                int color = applyKernel(inputImage, x, y, kernel);
                outputImage.setRGB(x, y, color);
            }
        });

        return outputImage;
    }

    public static int applyKernel(BufferedImage image, int x, int y, int[][] kernel) {
        int width = image.getWidth();
        int height = image.getHeight();
        int kernelSize = kernel.length;
        int halfKernelSize = kernelSize / 2;
        int[] rgbValues = new int[kernelSize * kernelSize];

        for (int i = -halfKernelSize; i <= halfKernelSize; i++) {
            for (int j = -halfKernelSize; j <= halfKernelSize; j++) {
                int newX = Math.min(Math.max(x + j, 0), width - 1);
                int newY = Math.min(Math.max(y + i, 0), height - 1);
                rgbValues[(i + halfKernelSize) * kernelSize + (j + halfKernelSize)] = image.getRGB(newX, newY);
            }
        }

        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < kernelSize * kernelSize; i++) {
            int color = rgbValues[i];
            int weight = kernel[i / kernelSize][i % kernelSize];
            red += ((color >> 16) & 0xFF) * weight;
            green += ((color >> 8) & 0xFF) * weight;
            blue += (color & 0xFF) * weight;
        }

        red = Math.min(Math.max(red, 0), 255);
        green = Math.min(Math.max(green, 0), 255);
        blue = Math.min(Math.max(blue, 0), 255);

        return (red << 16) | (green << 8) | blue;
    }
}

