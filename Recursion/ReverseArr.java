import java.util.Scanner;

public class ReverseArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        fun(arr, n, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }   
    
    static void fun(int[] arr, int n, int i, int j) {
        // 1 2 3
        // i   j

        // 3  2  1
        //   i j
        if (i >= j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // fun(arr, n, i++, j--); // passes the current value onto the next fun call and then increment the value of the i and j;
        // fun(arr, n, ++i, --j); // correct way, first it increment the value then pass it to the next fun.

        fun(arr, n, i + 1, j + 1);
    }
}
