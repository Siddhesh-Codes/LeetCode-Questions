import java.util.Scanner;

public class printName {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = sc.next();
        fun(n, name, 0);
    }

static void fun (int n, String name, int idx) {
        if (idx == n) {
            return;
        }

        System.out.println(name);

        fun(n, name, idx + 1);
    }
} 