// Definición de la clase MatrixMultiplicationThread
class MatrixMultiplicationThread extends Thread { 
    private int[][] matrixA;   // Matriz de entrada A
    private int[][] matrixB;   // Matriz de entrada B
    private int[][] result;    // Matriz de resultado
    private int row;           // Fila específica que este hilo calculará

    /**
    * Constructor de la clase MatrixMultiplicationThread.
    * @param matrixA Matriz de entrada A.
    * @param matrixB Matriz de entrada B.
    * @param result Matriz de resultado donde se almacenará el producto de las matrices.
    * @param row Fila específica que este hilo calculará en la matriz de resultado.
    */
    public MatrixMultiplicationThread(int[][] matrixA, int[][] matrixB, int[][] result, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
    }

    // Método run que se ejecutará cuando el hilo se inicie
    @Override
    public void run() {
        for (int i = 0; i < matrixB[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrixA[0].length; j++) {
                // Realiza la multiplicación y suma los valores
                sum += matrixA[row][j] * matrixB[j][i];
            }
            // Almacena el resultado en la matriz result
            result[row][i] = sum;
        }
    }

    // Método principal del programa
    public static void main(String[] args) {
        // Definición de las matrices de entrada A y B
        int[][] matrixA = {{4, 2, 6}, {2, 8, 9}, {4, 3, 7}};
        int[][] matrixB = {{2, 4, 5}, {2, 6, 7}, {3, 1, 8}};

        // Creación de la matriz result para almacenar el resultado
        int[][] result = new int[matrixA.length][matrixB[0].length];

        // Número de hilos a utilizar (uno por cada fila de la matriz A)
        int numThreads = matrixA.length;

        // Arreglo para almacenar los hilos
        Thread[] threads = new Thread[numThreads];

        // Inicialización y ejecución de los hilos
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new MatrixMultiplicationThread(matrixA, matrixB, result, i);
            threads[i].start();
        }

        // Espera a que todos los hilos terminen su ejecución
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Imprime la matriz de resultado en la consola
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
