public class MatrixProduct {

    public static  int[][]  matrixProduct_DAC(int[][] A,  int[][] B) {
        int row1 = A.length;
        int row2 = B.length;
        int col1 = A[0].length;
        int col2 = B[0].length;
        boolean flag;
        if (col1 != row2) {
            throw new IllegalArgumentException("usage: the number of " +
                    " columns in A must be equal to the number of rows in B\n");
        }
        if ((row1 != row2) || (col1 != col2)) {
            throw new IllegalArgumentException("Matrices A and B must be of same size \n");
        } else {
            // int n collects value  of col1 of Matrix A and row2 of Matrix B
            int n = col1 * row2;
            // flag used to check if value is of power of 2
            flag = powerOf2(n);
            if (flag == false) {
                throw new IllegalArgumentException("New Matrix size is not of power of 2 \n");


            }
        }
        int[][] C = new int[row1][col2];
        for(int i = 0;i < row1; i++)
        {
            
        }
    }












    private static boolean powerOf2(int n)
    {
        return (n & (n-1)) ==0;
    }
    //Compute and return the product of A, B matrices using “simple” DAC algorithm presented in class.

    public static  int[][]  matrixProduct_Strassen(int[][] A,  int[][] B)
    {
        int row1 = A.length;
        int row2 = B.length;
        int col1 = A[0].length;
        int col2 = B[0].length;
        return C;
    }
    //Compute and return the product of A, B matrixes using Strassen’s algorithm presented in class.
}
