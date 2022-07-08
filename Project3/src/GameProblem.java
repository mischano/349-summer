import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class GameProblem {

    public static void game(int n, int m, int[][] A)
    {
        //int[][]A
        //collects max route of each value from A
        int [][]S = new int[n][m];

        //
        int [][]R = new int[n][m];

    }
    static void main(String args[]) throws FileNotFoundException {
        int col, row;

        Scanner sc = new Scanner(System.in);
        System.out.print("file name:");
        String str = sc.nextLine();
        sc.close();

        String dir = System.getProperty("user.dir"); // get pwd
        // File fd = new File(str);
        File fd = new File(dir + "/" + str);
        Scanner file = new Scanner(fd); // new scanner

        // Matrix that is read from file
        row = file.nextInt();
        col = file.nextInt();
        int[][] A = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                A[i][j] = file.nextInt();
            }
        }

    }

}
