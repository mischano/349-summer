import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class GameProblem {

    public static void game(int n, int m, int[][] A)
    {
        int [][]S = new int[n][m];
        int [][]R = new int[n][m];

    }
    static void main(String args[]) throws FileNotFoundException {
        int[][] A;

        /* Read file name */
        Scanner sc = new Scanner(System.in);    // open scanner
        System.out.print("file name:");
        String str = sc.nextLine();
        sc.close(); // close scanner

        /* Read file content */
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

}
