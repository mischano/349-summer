import java.io.*;
import java.util.Scanner;
import java.util.*;

public class GameProblem {
    public static void main(String args[]) throws FileNotFoundException {
        int[][] A;

        /* Read file name */
        Scanner sc = new Scanner(System.in);    // open scanner
        System.out.print("file name:");
        String str = sc.nextLine();
        sc.close(); // close scanner

        /* Read file content & store in a 2D array*/
        File fd = new File(str);    
        Scanner file = new Scanner(fd); // new scanner

        int n = file.nextInt();
        int m = file.nextInt();
        A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = file.nextInt();
            }
        }
        file.close(); // close scanner

        game(A.length, A[0].length, A);
    }

    public static void game(int n, int m, int[][] A)
    {
        int[][] S = new int[n][m];
        int[][] R = new int[n][m];
        /* NOTE: R content:   
            right: 1
            done: 0
            down: -1 
        */

        int max = Integer.MIN_VALUE; 
        int iMax = Integer.MAX_VALUE;
        int jMax = Integer.MAX_VALUE;

        R[n-1][m-1] = 0;
        S[n-1][m-1] = A[n-1][m-1];
        
        if (S[n-1][m-1] > max) {
            iMax = n-1;
            jMax = m-1;
            max = S[n-1][m-1];
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (S[i + 1][m-1] < 0) {
                S[i][m-1] = A[i][m-1];
                R[i][m-1] = 0;
            } else {
                S[i][m-1] = S[i + 1][m-1] + A[i][m-1];
                R[i][m-1] = -1;
            }
            if (S[i][m-1] > max) {
                iMax = i;
                jMax = m-1;
                max = S[i][m-1];
            }
        }
        
        for (int j = m - 2; j >= 0; j--) {
            if (S[n-1][j + 1] < 0) {
                S[n-1][j] = A[n-1][j];
                R[n-1][j] = 0;
            } else {
                S[n-1][j] = S[n-1][j + 1] + A[n-1][j];
                R[n-1][j] = 1;
            }
            if (S[n-1][j] > max) {
                iMax = n-1;
                jMax = j;
                max = S[n-1][j];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (S[i + 1][j] < S[i][j + 1]) {
                    S[i][j] = S[i][j + 1] + A[i][j];
                    R[i][j] = 1;
                } else {
                    S[i][j] = S[i + 1][j] + A[i][j];
                    R[i][j] = -1;
                }
                if (S[i][j] > max) {
                    iMax = i;
                    jMax = j;
                    max = S[i][j];
                }
            }
        }
        System.out.println("Best score: " + max);
        System.out.print("Best route: ");
        while (!(R[iMax][jMax] == 0)) {
            System.out.format("[%d,%d] to ", iMax + 1, jMax + 1);
            if (R[iMax][jMax] == -1) {
                iMax++;
            } else {
                jMax++;
            }
        }
        System.out.format("[%d,%d] to exit", iMax + 1, jMax + 1);
        System.out.print("\n");
    }


}
