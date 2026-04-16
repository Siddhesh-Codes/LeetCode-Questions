import java.util.Scanner;

public class ReverseArrUsingSingleVariable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        fun(arr, 0, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void fun(int[] arr, int i, int n) {
        // if (i >= n) {
        //     return;
        // }

        if (i >= n / 2) {
            return;
        }

        int temp = arr[i];
        // arr[i] = arr[n - 1];
        arr[i] = arr[n - i - 1];
        // arr[n - 1] = temp;
        arr[n - i - 1] = temp;
        
        fun(arr, i + 1, n);
    }
}
