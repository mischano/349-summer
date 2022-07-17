public class Tester {
    public static void main(String[] args) throws Exception {
        int[][] input = new int[][] {
                { 100, 50, 25, 10, 5, 1 },
                { 100, 50, 20, 15, 10, 5, 3, 2, 1 },
                { 64, 32, 16, 8, 4, 2, 1 },
                { 100, 50, 25, 10, 1 },
                { 66, 35, 27, 18, 10, 1 } };
        int totalMatch, dpSum;
        System.out.println("Testing change_DP and change_greedy algorithms");
        for (int i = 0; i < 5; i++) {
            int[] arr = input[i];
            totalMatch = 0;
            for (int j = 1; j <= 200; j++) {
                int[] dp = ChangeMaker.change_DP(j, arr);
                int[] greedy = ChangeMaker.change_greedy(j, arr);
                dpSum = 0;
                int greedySum = 0;
                for (int k = 0; k < dp.length; k++) {
                    dpSum += dp[k];
                    greedySum += greedy[k];
                }
                if (dpSum == greedySum)
                    totalMatch++;
                else if (i == 0) {
                    System.out.println(j);
                    System.exit(0);
                }
            }

            System.out.println("Testing set" + (i + 1) + ": " + totalMatch + " totalMatch in 200 tests");
        }
    }
}