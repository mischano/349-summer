public class Algorithms {

    public static void linearAlgorithm(long n)
    {
        int x ;
        for(int i =1; i<n; i++)
        {
            x = 1;
        }
    }

    public static void quadraticAlgorithm(long n)
    {
        int x;
        for(int i=1; i<n; i++) {
            for (int j = 1; j < n; j++)
                x = 1;
        }
    }
    public static void cubicAlgorithm(long n)
    {
        int x;
        for(int i = 1; i <n; i++)
        {
            for(int j =1; j< n; j++) {
                for (int k = 1; k < n; k++) {
                    x = 1;
                }
            }
        }
    }
    public static void logarithmicAlgorithm(long n)
    {
        int x;
        for(long i = n; i>=1; i/=2 ){
            x=1;
        }

    }
    public static void NlogNAlgorithm(long n) {
        int x;
        for (int i = 1; i < n; i++) {
            for (long j = n; j >= 1; j /= 2) {
                x = 1;
            }
        }
    }


}
