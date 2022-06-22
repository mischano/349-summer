public class SortTimes extends Sorts {
    public static void main(String[] args) throws Exception {
        int t1, t2, t3, t4;
        long startTime;

        System.out.println("Running Times of four sorting algorithms:");
        for (int i = 5000; i <= 160000; i *= 2) {
            for (int j = 0; j < 4; j++) {
                int[] ss = new int[i];
                int[] bs = new int[i];
                int[] ms = new int[i];
                int[] qs = new int[i];
                for (int k = 0; k < i; k++) {
                    int rand = (int) (Math.random() * i);
                    ss[k] = rand;
                    bs[k] = rand;
                    ms[k] = rand;
                    qs[k] = rand;
                }
                startTime = System.nanoTime();
                selectionSort(ss, i);
                t1 = (int) ((System.nanoTime() - startTime) / 1000000);
                
                startTime = System.nanoTime();
                bubbleSort(bs, i);
                t2 = (int) ((System.nanoTime() - startTime) / 1000000);
                
                startTime = System.nanoTime();
                mergeSort(ms, i);
                t3 = (int) ((System.nanoTime() - startTime) / 1000000);
                
                startTime = System.nanoTime();
                quickSort(qs, i);
                t4 = (int) ((System.nanoTime() - startTime) / 1000000);

                System.out.format("N=%d: T_ss=%d, T_bs=%d, T_ms=%d, T_qs=%d", i, t1, t2, t3, t4);
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }
}
