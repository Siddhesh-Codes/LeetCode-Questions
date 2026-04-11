import java.util.Scanner;

public class print1toN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fun(1, n);
    }

    static void fun(int idx, int n) {
        if(idx > n) return ;
        
        System.out.println(idx);
        fun(idx + 1, n);   
    }
}
