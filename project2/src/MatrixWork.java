import java.io.*;
import java.util.*;

public class MatrixWork {
    public static int[][] matrixProduct(int[][] A, int[][] B) {
        int row1 = A.length;
        int row2 = B.length;
        int col1 = A[0].length;
        int col2 = B[0].length;

        if (col1 != row2) {
            throw new IllegalArgumentException("col and row don't match");
        }
        int[][] C = new int[row1][col2];
        
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) throws Exception {
        int col, row;

        Scanner sc = new Scanner(System.in); // new scanner 
        System.out.print("file name:");
        String str = sc.nextLine();
        sc.close(); // close scanner

        File fd = new File("project2/src/" + str);    
        Scanner file = new Scanner(fd); // new scanner

        // Matrix A 
        row = file.nextInt();
        col = file.nextInt();
        int[][] A = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                A[i][j] = file.nextInt();
            }
        }
        
        // Matrix B 
        row = file.nextInt();
        col = file.nextInt();
        int[][] B = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                B[i][j] = file.nextInt();
            }
        }
        file.close();   // close scanner
        int[][] C = matrixProduct(A, B);

        System.out.println("Product matrix:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
