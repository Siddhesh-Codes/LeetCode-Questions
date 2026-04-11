import java.util.Scanner;

public class printNto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int idx = sc.nextInt();
        fun(idx, n);
    }

    static void fun(int idx, int n) {
        if (idx == n) {
            return;
        }

        System.out.println(n);

        fun(idx, n - 1);
    }
}
