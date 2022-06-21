public class Runtimes {




        static void main()
        {
            long endTime = 0;
            long startTime = 0;

            long max = 100000000;
            long divisor = 1000000;
            System.out.println("Logarithmic algorithm's running times;\n");
            for(int i = 1000; i < max; i *= 2)
            {
                startTime = System.nanoTime();
                Algorithms.linearAlgorithm(i);
                endTime = (System.nanoTime()-startTime)/divisor ;
                System.out.format("T(%d) = %d", i, endTime);


            }
        }

    }



