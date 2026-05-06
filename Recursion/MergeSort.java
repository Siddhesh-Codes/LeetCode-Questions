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
        if (low >= high) {
            return;
        }
        int mid = (low + high) >>> 1;
        mergeSort(arr, low, mid, n);
        mergeSort(arr, mid + 1, high, n);
        merge(arr, low, mid, high, n);
    }

    // Merge final arrays
    static void merge(int[] arr, int low, int mid, int high, int n) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        } 
        
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

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

// Issues fixed in this implementation:
// 1. Base case was incorrect; should be 'low >= high'.
// 2. Recursive calls were wrong; should split at mid.
// 3. Initial call used wrong high index; should be n-1.
// 4. Merge copy-back loop bounds were incorrect.
