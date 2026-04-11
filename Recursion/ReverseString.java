import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        fun(s, 0);
    }

    static void fun(String s, int idx) {
        if (idx >= s.length()) {
            return;
        }

        fun(s, idx + 1);
        System.out.print(s.charAt(idx));
    }
}
