// Mansur Ischanov (mischano@calpoly.edu) & Luis Magallon (lmagal01@calpoly.edu)
// June 26th, 2022
// Project 1

public class Sorts {

    public static  void  selectionSort (int[] arr, int N)
    {
        for(int i = 0; i < N; i++) {
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
        }
        for(int x = 0; x < arr.length; x++)
        System.out.println(arr[x] +" " );

    }

    public static  void  bubbleSort (int[] arr, int N)
    {
        boolean swapped = true;
        int n = N;
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
        }
    }

    public static void mergeSort (int[] arr, int N)
    {
        int first = 0;
        int last = N - 1;
        mergeSort(arr, first, last);
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

    public static void quickSort (int[] arr, int N) {
        int first = 0;
        int last = N - 1;
        quickSort(arr, first, last);
    }

    private static void quickSort(int[] arr, int first, int last) {
        if (first < last) {
            setPivotToEnd(arr, first, last);
            int pivotIndex = splitList(arr, first, last);
            quickSort(arr, first, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, last);
        }
    }

    private static void setPivotToEnd(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[center] < arr[left]) {
            int temp = arr[left];
            arr[left] = arr[center];
            arr[center] = temp;
        }
        if (arr[right] < arr[left]) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        if (arr[right] > arr[center]) {
            int temp = arr[center];
            arr[center] = arr[right];
            arr[right] = temp;
        }
    }

    private static int splitList(int[] arr, int left, int right) {
        int indexL = left;
        int indexR = right - 1;
        while (indexR >= indexL) {
            while (arr[indexL] < arr[right]) {
                indexL++;
            }
            while (indexR >= indexL && arr[indexR] > arr[right]) {
                indexR--;
            }
            if (indexR >= indexL) {
                int temp = arr[indexL];
                arr[indexL] = arr[indexR];
                arr[indexR] = temp;
                indexL++;
                indexR--;
            }
        }
        int temp = arr[indexL];
        arr[indexL] = arr[right];
        arr[right] = temp;
        return indexL;
    }
}
