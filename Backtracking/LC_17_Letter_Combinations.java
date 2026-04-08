
// Mistake Log: Letter Combinations of a Phone Number
// Pattern: Backtracking / Hash Table
// Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Mistake (Syntax): Tried map['2'] and str[i].
// Fix: Use map.put('2', "abc") and str.charAt(i) in Java.

// Mistake (Backtracking): Attempted manual list.add() and list.remove() to manage the current string.
// Fix: Use Functional Backtracking. Since Strings are immutable, passing "curr + char" creates a new object for each call, handling the "undo" step automatically.

// Mistake (Edge Case): Forgot to handle digits = "".
// Fix: Must return [], not [""].

// Key Insight: Use Mutable (StringBuilder) if performance/memory is an issue; use Immutable (String) for cleaner, bug-free recursion logic in small constraints (length <= 4).

// Learning: When working with recursion, the choice of data structure matters: Immutable types (String) manage state on the stack automatically, while Mutable types (StringBuilder/ArrayList) require manual cleanup (backtracking).

package Backtracking;
import java.util.*;

public class LC_17_Letter_Combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digits: ");
        String digits = sc.nextLine();

        Solution sol = new Solution();

        List<String> result = sol.letterCombinations(digits);

        System.out.println("Combinations: " + result);

        sc.close();
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return ans;

        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        fun(digits, 0, "", ans, map);

        return ans;
    }

    void fun(String digit, int idx, String curr, List<String> ans, Map<Character, String> map) {
        if (idx == digit.length()) {
            ans.add(curr);
            return;
        }

        String choice = map.get(digit.charAt(idx));

        for (int i = 0; i < choice.length(); i++) {
            fun(digit, idx + 1, curr + choice.charAt(i), ans, map);
        }
        return;
    }
}
