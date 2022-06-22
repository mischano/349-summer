import java.util.*;
import java.io.*;
public class Runtimes {



    public static void main(String[] args)   {
       long endTime = 0;
       long startTime = 0;

       long max = 100000000;
       long divisor = 1000000;
       long divisor2 = 512000;
        System.out.println("Logarithmic algorithm's running times:");
        for(int i = 1000; i <= max; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.logarithmicAlgorithm(i);
            endTime = (System.nanoTime() - startTime) / divisor;
            System.out.format("T(%d) = %d\n", i, endTime);
        }
        System.out.println('\n');
       System.out.println("Linear algorithm's running times:");
       for(int i = 1000; i <= max; i *= 2) {
           startTime = System.nanoTime();
           Algorithms.linearAlgorithm(i);
           endTime = (System.nanoTime() - startTime) / divisor;
           System.out.format("T(%d) = %d\n", i, endTime);
       }
        System.out.println('\n');
        System.out.println("NlogN algorithm's running times:");
        for(int i = 1000; i <= max; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.NlogNAlgorithm(i);
            endTime = (System.nanoTime() - startTime) / divisor;
            System.out.format("T(%d) = %d\n", i, endTime);
        }
        System.out.println('\n');
        System.out.println("Quadratic algorithm's running times:");
        for(int i = 1000; i <= 512000; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.quadraticAlgorithm(i);
            endTime = (System.nanoTime() - startTime) / divisor;
            System.out.format("T(%d) = %d\n", i, endTime);
        }
        System.out.println('\n');
        System.out.println("Cubic algorithm's running times:");
        for(int i = 1000; i <= 8000; i *= 2) {
            startTime = System.nanoTime();
            Algorithms.cubicAlgorithm(i);
            endTime = (System.nanoTime() - startTime) / divisor;
            System.out.format("T(%d) = %d\n", i, endTime);
        }
   }

}
