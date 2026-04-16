import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        boolean ans = fun(s, 0, s.length());
        System.out.println(ans);
    }

    static boolean fun(String s, int i, int n) {
        if (i >= n - i - 1) {
            return true;
        }
        
        if (s.charAt(i) != s.charAt(n - i - 1)) {
            return false;
        }

        return fun(s, i + 1, n);
    }
}
