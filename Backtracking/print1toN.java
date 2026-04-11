// package Backtracking;

import java.util.Scanner;

public class print1toN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int i = sc.nextInt();
        
        fun(n, n);
    }

    static void fun (int n, int i) {
        if (i <= 0) {
            return;
        }

        fun(n, i - 1);
        System.out.println(i);
    }
}
