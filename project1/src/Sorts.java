public class Sorts {

    public static  void  selectionSort (int[] arr, int N)
    {
        /* for(int i = 0; i < N; i++) {
            int index = i;
            for(int j = i + 1; j < N; j++)
            {
                if (arr[j] < arr[index])
                {
                    index = j;
                }
            }
            int k = arr[index];
            arr[index] = arr[i];
            arr[i] = k;
        } */
    }

    //Sorts the list of N elements contained in arr[0..N-1] using the selection sort algorithm.
    public static  void  bubbleSort (int[] arr, int N)
    {
        /* int n = N;
        boolean swapped = true;
        int temp = 0;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            n--;
        } */
    }

    //Sorts the list of N elements contained in arr[0..N-1] using the improved bubble sort algorithm
    //(see the handout).
    public static void mergeSort (int[] arr, int N)
    {
        int first = 0;
        int last = N - 1;
        mergeSort(arr, first, last);

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");
    }

    private static void mergeSort(int[] list, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(list, first, middle);
            mergeSort(list, middle+1, last);
            mergeSortedHalves(list, first, middle, last);
        }
    }

    private static void mergeSortedHalves(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int x, y, k;
        x = y = 0;
        k = left;
        while ( x < n1 &&  y < n2) {
            if (leftArray[x] <= rightArray[y]) {
                arr[k] = leftArray[x];
                x++;
            }
            else {
                arr[k] = rightArray[y];
                y++;
            }
            k++;
        }
        while (x < n1) {
            arr[k] = leftArray[x];
            x++;
            k++;
        }
        while (y < n2) {
            arr[k] = rightArray[y];
            y++;
            k++;
        }
    }

    //Sorts the list of N elements contained in arr[0..N-1] using the merge sort algorithm.
    public static void quickSort (int[] arr, int N) {
        // choose the rightmost element as pivot
        /* int pivot = arr[N-1];

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
        */
    } 
    //Sorts the list of N elements contained in arr[0..N-1] using the quick sort algorithm with
    //median-of-three pivot and rearrangement of the three elements (see the handout).
}
