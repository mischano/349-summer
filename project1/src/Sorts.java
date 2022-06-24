public class Sorts {

    public static  void  selectionSort (int[] arr, int N)
    {
        for(int i =0; i <= N; i++) {
            int index = i;
            for(int j = i+1; j<N; j++)
            {
                if (arr[j] < arr[index])
                {
                    index = j;
                }
            }
        }
    }
    //Sorts the list of N elements contained in arr[0..N-1] using the selection sort algorithm.
    public static  void  bubbleSort (int[] arr, int N)
    {
        int k;
        for (int i = N; i >= 0; i--) {
            for (int j = 0; j< N - 1; j++) {
                k = i + 1;
                if (arr[i] > arr[k]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }


    }

    //Sorts the list of N elements contained in arr[0..N-1] using the improved bubble sort algorithm
    //(see the handout).
    public static void mergeSort (int[] arr, int N)
    {

        //runtime O(nlogn)

    }
    //Sorts the list of N elements contained in arr[0..N-1] using the merge sort algorithm.
    public static void quickSort (int[] arr, int N) {
        // choose the rightmost element as pivot
        int pivot = arr[N-1];

        int num = arr[0];

        for (int i = 0; i < N-1; i++) {
            if (arr[i] <= pivot) {

                num++;

                // swapping element at i with element at j
                int temp = arr[num];
                arr[num] = arr[i];
                arr[i] = temp;
            }
        }
    }
    //Sorts the list of N elements contained in arr[0..N-1] using the quick sort algorithm with
    //median-of-three pivot and rearrangement of the three elements (see the handout).
}
