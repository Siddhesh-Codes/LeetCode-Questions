// package Backtracking;

import java.util.Scanner;

public class printNto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        fun(n,i);
    }

    private static void fun(int n, int n2) {
        if (n2 > n) {
            return;
        }

        fun(n, n2 + 1);
        System.out.println(n2);
    }
}   
