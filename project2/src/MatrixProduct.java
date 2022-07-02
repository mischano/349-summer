// Mansur Ischanov (mischano@calpoly.edu) & Luis Magallon (lmagal01@calpoly.edu)
// July 2nd, 2022
// Project 2

import java.util.ArrayList;
import java.util.Collections;

public class MatrixProduct {
    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        matrixValidityCheck(A, B);
        int startColA = 0;
        int startColB = 0;
        int startRowA = 0;
        int startRowB = 0;

        return matrixProduct_DAC(A, startColA, startRowA, B, startColB,
                startRowB, A.length);
    }

    public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
        matrixValidityCheck(A, B);
        int startColA = 0;
        int startColB = 0;
        int startRowA = 0;
        int startRowB = 0;

        return matrixProduct_Strassen(A, startRowA, startColA, B, startColB,
                startRowB, A.length);
    }

    private static void matrixValidityCheck(int[][] A, int[][] B) {
        int a = A.length;
        int b = B.length;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);

        for (int i = 0; i < Math.min(arr.get(1), arr.get(0)); i++) {
            a = A[i].length;
            b = B[i].length;
            arr.add(a);
            arr.add(b);
        }
        ArrayList<Integer> exp;
        exp = new ArrayList<>(Collections.nCopies(arr.size(), arr.get(0)));
        double x = Math.log(A.length) / Math.log(2) % 1;
        if (!arr.equals(exp) || x != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int[][] matrixProduct_DAC(int[][] A, int rowA, int colA,
            int[][] B, int rowB, int colB, int n) {
        int[][] C;
        C = new int[n][n];

        if (n != 1) {
            int[][][] quad = {
                    matrixAdd(matrixProduct_DAC(A, rowA, colA, B, rowB,
                            colB, n / 2),
                            matrixProduct_DAC(A, rowA, colA + (n / 2), B,
                                    rowB + (n / 2), colB, n / 2),
                            n / 2, false),
                    matrixAdd(matrixProduct_DAC(A, rowA, colA, B, rowB,
                            colB + (n / 2), n / 2),
                            matrixProduct_DAC(A, rowA, colA + (n / 2), B,
                                    rowB + (n / 2), colB + (n / 2), n / 2),
                            n / 2,
                            false),
                    matrixAdd(matrixProduct_DAC(A, rowA + (n / 2), colA, B,
                            rowB, colB, n / 2),
                            matrixProduct_DAC(A, rowA + (n / 2), colA + (n / 2),
                                    B, rowB + (n / 2), colB, n / 2),
                            n / 2,
                            false),
                    matrixAdd(matrixProduct_DAC(A, rowA + (n / 2), colA, B,
                            rowB, colB + (n / 2), n / 2),
                            matrixProduct_DAC(A, rowA + (n / 2), colA + (n / 2),
                                    B, rowB + (n / 2), colB + (n / 2),
                                    n / 2),
                            n / 2, false)
            };
            C = combQuad(quad, n);
        } else {
            C[0][0] = A[rowA][colA] * B[rowB][colB];
        }
        return C;
    }

    private static int[][] matrixProduct_Strassen(int[][] A, int[][] B, int n) {
        return matrixProduct_Strassen(A, 0, 0, B, 0, 0, n);
    }

    private static int[][] matrixProduct_Strassen(int[][] A, int startRowA,
            int startColA, int[][] B, int startRowB, int startColB, int n) {
        int[][] C = new int[n][n];
        if (n != 1) {
            int[][][] S = {
                    matrixAdd(B, startRowB, startColB + (n / 2), B, startRowB + (n / 2), startColB + (n / 2), n / 2,
                            true),
                    matrixAdd(A, startRowA, startColA, A, startRowA, startColA + (n / 2), n / 2, false),
                    matrixAdd(A, startRowA + (n / 2), startColA, A, startRowA + (n / 2), startColA + (n / 2), n / 2,
                            false),
                    matrixAdd(B, startRowB + (n / 2), startColB, B, startRowB, startColB, n / 2, true),
                    matrixAdd(A, startRowA, startColA, A, startRowA + (n / 2), startColA + (n / 2), n / 2, false),
                    matrixAdd(B, startRowB, startColB, B, startRowB + (n / 2), startColB + (n / 2), n / 2, false),
                    matrixAdd(A, startRowA, startColA + (n / 2), A, startRowA + (n / 2), startColA + (n / 2), n / 2,
                            true),
                    matrixAdd(B, startRowB + (n / 2), startColB, B, startRowB + (n / 2), startColB + (n / 2), n / 2,
                            false),
                    matrixAdd(A, startRowA, startColA, A, startRowA + (n / 2), startColA, n / 2, true),
                    matrixAdd(B, startRowB, startColB, B, startRowB, startColB + (n / 2), n / 2, false)
            };
            int[][][] P = {
                    matrixProduct_Strassen(A, startRowA, startColA, S[0], 0, 0, n / 2),
                    matrixProduct_Strassen(S[1], 0, 0, B, startRowB + (n / 2), startColB + (n / 2), n / 2),
                    matrixProduct_Strassen(S[2], 0, 0, B, startRowB, startColB, n / 2),
                    matrixProduct_Strassen(A, startRowA + (n / 2), startColA + (n / 2), S[3], 0, 0, n / 2),
                    matrixProduct_Strassen(S[4], S[5], n / 2),
                    matrixProduct_Strassen(S[6], S[7], n / 2),
                    matrixProduct_Strassen(S[8], S[9], n / 2)
            };
            int[][][] quadrants = {
                    matrixAdd(matrixAdd(matrixAdd(P[4], P[3], n / 2, false), P[1], n / 2, true), P[5], n / 2, false),
                    matrixAdd(P[0], P[1], n / 2, false),
                    matrixAdd(P[2], P[3], n / 2, false),
                    matrixAdd(matrixAdd(matrixAdd(P[4], P[0], n / 2, false), P[2], n / 2, true), P[6], n / 2, true)
            };
            C = combQuad(quadrants, n);
        } else {
            C[0][0] = A[startRowA][startColA] * B[startRowB][startColB];
        }
        return C;
    }

    private static int[][] combQuad(int[][][] quadrants, int n) {
        int[][] m = new int[n][n];
        int[][] COORDS = { { 0, 0 }, { 0, n / 2 }, { n / 2, 0 }, { n / 2, n / 2 } };
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                for (int k = 0; k < 4; k++) {
                    m[i + COORDS[k][0]][j + COORDS[k][1]] = quadrants[k][i][j];
                }
            }
        }
        return m;
    }

    private static int[][] matrixAdd(int[][] A, int[][] B, int n, boolean subtract) {
        return matrixAdd(A, 0, 0, B, 0, 0, n, subtract);
    }

    private static int[][] matrixAdd(int[][] A, int startRowA, int startColA, int[][] B, int startRowB, int startColB,
            int n, boolean subtract) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!subtract) {
                    C[i][j] = A[i + startRowA][j + startColA] + B[i + startRowB][j + startColB];
                } else {
                    C[i][j] = A[i + startRowA][j + startColA] - B[i + startRowB][j + startColB];
                }
            }
        }
        return C;
    }
}
