// Problem: 78. Subsets (Medium)

// Idea: Use recursion to build subsets in a temp list.

// Stuck At: Outputted empty lists [[], []]. Forgot the logic behind the "exclude" step.

// Key Insight: 
// 1. Base case needs a deep copy: new ArrayList<>(temp).
// 2. Power sets require a binary decision tree: Pick it OR Skip it.

// Pattern: Backtracking (Pick / Skip).

// Mistake: Passed the temp reference instead of a copy. Forgot the "Skip" recursive branch.

// Key Learning: Always deep copy tracking objects into the result list. Power sets require explicitly exploring paths without the current element.

package Backtracking;
import java.util.*;
public class LC_70_Subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println(result);
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        fun(0, nums, ans, temp, nums.length);

        return ans;
    }

    public void fun (int idx, int[] nums, List<List<Integer>> list, List<Integer> temp, int n) {

        if (idx == n) {
            list.add(new ArrayList<>(temp));

            return;
        }

        temp.add(nums[idx]);

        fun(idx + 1, nums, list, temp, n);

        temp.remove(temp.size() - 1);


        fun(idx + 1, nums, list, temp, n);
    }
}