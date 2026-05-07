
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
// import java.util.Scanner;
import java.io.IOException;

/* 
Algo:
1. pick a pivot from the array and place it in its correct position.
2. smaller on the left and larger on the right of the pivot
*/

public class QuickSort {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        
        quickSort(arr, 0, arr.length - 1);
        
        // Print sorted array
        // for (int i = 0; i < arr.length; i++) {
            // System.out.print(arr[i] + " ");
            // }
            System.out.println(Arrays.toString(arr));
        }
        
        static void quickSort(int[] arr, int low, int high) {
            if (low < high) { // base case to stop recursion
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi);
                quickSort(arr, pi + 1, high);
            }
        }
        
        static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        // Sort in Descending Order
        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }

            while (arr[j] > pivot && j > low) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;               
            }        
        }
        
        // Sort in Ascending Order
        // while (i < j) {
        //     while (arr[i] > pivot && i < high) {
        //         i++;
        //     }

        //     while (arr[j] <= pivot && j > low) {
        //         j--;
        //     }

        //     if (i < j) {
        //         int temp = arr[i];
        //         arr[i] = arr[j];
        //         arr[j] = temp;               
        //     }
        // }
        
        // for (int j = low + 1; j <= high; j++) {
        //     if (arr[j] < pivot) {
        //         i++;
        //         int temp = arr[i];
        //         arr[i] = arr[j];
        //         arr[j] = temp;
        //     }
        // }

        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        
        return j;
    }
}

/*
// Hoare partition scheme (for reference)
static int hoarePartition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low - 1;
    int j = high + 1;
    while (true) {
        // Move i to the right until arr[i] >= pivot
        do {
            i++;
        } while (arr[i] < pivot);

        // Move j to the left until arr[j] > pivot
        do {
            j--;
        } while (arr[j] > pivot);

        // If pointers cross, return j
        if (i >= j)
            return j;

        // Swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
*/