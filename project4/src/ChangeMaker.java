import java.util.ArrayList;
import java.util.Scanner;

public class ChangeMaker {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of coin-denominations and the setof coin values:");
        int[] coin_denom = new int[in.nextInt()];

        int index;
        for (index = 0; index < coin_denom.length; index++) {
            coin_denom[index] = in.nextInt();
        }
        System.out.print("\n");
        
        System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
        int amount;
        while ((amount = in.nextInt()) != 0) {
            int[] resGreedy = change_greedy(amount, coin_denom);
            int[] resDP = change_DP(amount, coin_denom);
            ArrayList<String> distDP = new ArrayList<>();
            ArrayList<String> distGreedy = new ArrayList<>();

            int countDP = 0;
            int countGreedy = 0;

            int i = 0;
            while (i < coin_denom.length) {
                if (resGreedy[i] > 0) {
                    distGreedy.add(resGreedy[i] + "*" + coin_denom[i] + "c");
                    countGreedy += resGreedy[i];
                }
                if (resDP[i] > 0) {
                    distDP.add(resDP[i] + "*" + coin_denom[i] + "c");
                    countDP += resDP[i];
                }
                i++;
            }
            System.out.print("\n");
            System.out.format("DP algorithm results\nAmount: %d\nOptimal distribution: %s\nOptimal coin count: %d",
                    amount, String.join(" + ", distDP), countDP);
            System.out.print("\n");

            System.out.print("\n");
            System.out.format(
                    "Greedy algorithm results\nAmount: %d\nOptimal distribution: %s\nOptimal coin count: %d",
                    amount, String.join(" + ", distGreedy), countGreedy);
            System.out.print("\n");
            
            System.out.println("\nEnter a positive amount to be changed (enter 0 to quit):");
        }
        System.out.println("Thanks for playing. Good Bye.");
    }

    public static int[] change_DP(int n, int[] d) {
        int[] A = new int[n];
        int[] C = new int[n];
        int[] B = new int[d.length];
        int index, rem, sum, next, count;
        int len = d.length - 1;
        A[0] = len;
        C[0] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < d.length; j++) {
                rem = i - d[j];
                if (rem == 0) {
                    C[i - 1] = 1;
                    A[i - 1] = j;
                    min = 0;
                } else if (rem > 0) {
                    index = 1;
                    sum = C[rem - 1];
                    if (min > index + sum) {
                        C[i - 1] = min;
                        A[i - 1] = j;
                        min = index + sum;
                    }
                }
            }
        }
        next = A[n - 1];
        B[next] += 1;
        count = n - d[next];
        while (0 < count) {
            next = A[count - 1];
            B[next] += 1;
            count -= d[next];
        }
        return B;
    }

    public static int[] change_greedy(int n, int[] d) {
        int[] counts = new int[d.length];
        int i = 0;
        while (i < d.length && n > 0) {
            int count = n / d[i];
            counts[i] = count;
            n -= d[i] * count;
            i++;
        }
        return counts;
    }
}
