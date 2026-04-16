// Functional way!

import java.util.Scanner;

public class SumOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fun(n));
    }

    // n = 3
    // 3 + 2 + 1 = 6
    static int fun (int n) {
        if (n == 1) {
            return 1;
        }

        return n + fun(n - 1);
    }
}
