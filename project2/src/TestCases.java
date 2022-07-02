import java.util.concurrent.ThreadLocalRandom;

public class TestCases extends MatrixProduct{
    private static int N = 2;
    private static int N_MAX = 257;
    
    public static void main(String[] args) {
        int [][] A, B, C, D;

        for (int i = N; i <= N_MAX; i *= 2) {
            // Randomize matrices
            A = initArr(i);
            B = initArr(i);
            
            // Multiply matrices
            C = matrixProduct_DAC(A, B);
            D = matrixProduct_Strassen(A, B);

            // Test Matrices
            testResults(C, D, i);
        }
        System.out.println("all tests passed.");
    }

    private static void testResults(int[][] A, int[][] B, int index) {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if (A[i][j] != B[i][j]) {
                    throw new ArithmeticException();
                }
            }
        }
        System.out.println("test:" + index + "x" + index + " passed");
    }

    private static int[][] initArr(int index) {
        int arr [][] = new int[index][index];

        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                arr[i][j] = (int) ThreadLocalRandom.current().nextInt(-10, 10);
            }
        }
        
        return arr;
    }
}
