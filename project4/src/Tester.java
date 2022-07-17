import java.util.ArrayList;

public class Tester extends ChangeMaker {



    public static void main(String[] args){


        int[] USD = new int[]{100,50,25,10,5,1};
        int[] soviet = new int[]{100, 50, 20, 15, 10, 5, 3, 2, 1};
        int[] powersOf2 = new int[]{64, 32, 16, 8, 4, 2, 1};
        int[] USDwithNo5 = new int[]{100, 50, 25, 10, 1};
        int[] someSet = new int[]{66, 35, 27, 18, 10, 1};
        // = new int[200];


        int countGreedy = 0;
        int countDP = 0;
        int countCommon = 0; // counts if both DP and Greedy are the same
        int countCommon2 = 0;
        int countCommon3 = 0;
        int countCommon4 = 0;
        int countCommon5 = 0;
                


        int [] resGreedy = change_greedy(200,USD);
        int [] resDP = change_DP(200,USD);
        for(int i = 0; i<= 200; i++) {

            countGreedy += resGreedy[i];
            countDP += resDP[i];
            if(countGreedy == countDP)
                countCommon++;
        }

        int [] resGreedy2 = change_greedy(200,soviet);
        int [] resDP2 = change_DP(200,soviet);
        for(int i = 0; i<= 200; i++) {

            countGreedy += resGreedy[i];
            countDP += resDP[i];
            if(countGreedy == countDP)
                countCommon++;
        }

        int [] resGreedy3 = change_greedy(200,someSet);
        int [] resDP3 = change_DP(200,someSet);
        for(int i = 0; i<= 200; i++) {

            countGreedy += resGreedy[i];
            countDP += resDP[i];
            if(countGreedy == countDP)
                countCommon++;
        }

        int [] resGreedy4 = change_greedy(200,USDwithNo5);
        int [] resDP4 = change_DP(200,USDwithNo5);
        for(int i = 0; i<= 200; i++) {

            countGreedy += resGreedy[i];
            countDP += resDP[i];
            if(countGreedy == countDP)
                countCommon++;
        }

        int [] resGreedy5 = change_greedy(200,powersOf2);
        int [] resDP5 = change_DP(200,powersOf2);
        for(int i = 0; i<= 200; i++) {

            countGreedy += resGreedy[i];
            countDP += resDP[i];
            if(countGreedy == countDP)
                countCommon++;
        }

        System.out.println("Testing set1: " + countCommon + " matches in 200 tests\n");
        System.out.println("Testing set1: " + countCommon2 + " matches in 200 tests");
        System.out.println("Testing set1: " + countCommon3 + " matches in 200 tests");
        System.out.println("Testing set1: " + countCommon4 + " matches in 200 tests");
        System.out.println("Testing set1: " + countCommon5 + " matches in 200 tests");



    }

}
