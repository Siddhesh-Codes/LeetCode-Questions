import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n - 1, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }

    // Merge Sort (using Recursion)
    static void mergeSort(int[] arr, int low, int high, int n) {
        // Base case: If the array has one or zero elements, it's already sorted
        if (low >= high) {
            return;
        }
        
        // Find the midpoint of the array 
        // WHY? - To split the array into two halves for recursive sorting
        int mid = (low + high) >>> 1;

        // Recursively sort the left and right halves
        // WHY? - To break down the problem into smaller subproblems until we reach the base case
        mergeSort(arr, low, mid, n);
        mergeSort(arr, mid + 1, high, n);

        // Merge the sorted halves
        // WHY? - To combine the sorted halves back into a single sorted array
        merge(arr, low, mid, high, n);
    }

    // Merge final arrays
    static void merge(int[] arr, int low, int mid, int high, int n) {
        // Create a temporary list to hold the merged result
        // WHY? - To store the merged elements before copying them back to the original array
        List<Integer> temp = new ArrayList<>();

        // Merge the two halves while maintaining sorted order
        // WHY? - To combine the sorted elements from both halves in the correct order
        int left = low, right = mid + 1;

        // Compare elements from both halves and add the smaller one to the temp list
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        
        // If there are remaining elements in the left half, add them to temp
        // WHY? - To include any leftover elements from the left half that haven't been added to temp yet
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        } 
        
        // If there are remaining elements in the right half, add them to temp
        // WHY? - To include any leftover elements from the right half that haven't been added to temp yet
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy the merged result back into the original array
        // WHY? - To update the original array with the sorted elements from temp
        // WHY to start from 'low' and go to 'high'? - Because we are merging the subarray defined by these indices, and we need to ensure we copy back to the correct portion of the original array

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}

// Time Complexity (TC): O(n log n)
// Space Complexity (SC): O(n)
// - Each mergeSort call splits the array in half (log n levels)
// - Each merge step processes all n elements at each level
// - Extra space for temp array during merge is O(n)
// - Recursion stack space is O(log n), but temp array dominates


// Issues fixed in this implementation:
// 1. Base case was incorrect; should be 'low >= high'.
//    Before: if (low >= high && low >= mid) { return; }
//    After:  if (low >= high) { return; }
// 2. Recursive calls were wrong; should split at mid.
//    Before: mergeSort(arr, low, high, n); mergeSort(arr, mid + 1, high, n);
//    After:  mergeSort(arr, low, mid, n); mergeSort(arr, mid + 1, high, n);
// 3. Initial call used wrong high index; should be n-1.
//    Before: mergeSort(arr, 0, n, n);
//    After:  mergeSort(arr, 0, n - 1, n);
// 4. Merge copy-back loop bounds were incorrect.
//    Before: for (int i = low; i < temp.size(); i++) { arr[i] = temp.get(i - low); }
//    After:  for (int i = low; i <= high; i++) { arr[i] = temp.get(i - low); }
