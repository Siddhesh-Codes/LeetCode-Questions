// Problem Name: 39. Combination Sum 
// Problem Link: https://leetcode.com/problems/combination-sum/
// Pattern Used: Backtracking
// Rating: Medium

// Time spent thinking: ~20 minutes 

// My Idea: Use "include/exclude" recursion to pick numbers, staying on the same index for the "include" choice since the same number can be used unlimited times.

// Where I got stuck: The final answer list was returning empty/incorrectly, and trying to merge lists caused a compilation error. 

// Key Insight: In Java, `ans.add(temp)` only saves a "reference" to the list. Since backtracking modifies that same `temp` list later, the saved results get wiped out. Creating a new copy via `new ArrayList<>(temp)` fixes this.


// Mistake I made: Saving the reference of the temporary list instead of a deep copy, and confusing `.addAll()` with `.add()`.

// Key Learning: Always make a copy of your tracking list when adding it to the final result array in backtracking!


package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC_39_Combination_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.err.print("Enter the size of the arr: ");
        int n = sc.nextInt();

        System.err.print("Enter the elements of the arr: ");
        int[] candidates = new int[n];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = sc.nextInt();
        }

        System.err.print("Enter the Target: ");
        int target = sc.nextInt();

        Solution solution = new Solution();
        List<List<Integer>> ans = solution.combinationSum(candidates, target);
        System.out.println(ans);
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        fun(candidates, target, 0, ans, new ArrayList<>(), 0);
        return ans;
    }

    void fun(int[] arr, int target, int idx, List<List<Integer>> ans, List<Integer> temp, int sum) {
        if (arr.length == idx) {
            if (sum == target) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // Skip Choice
        fun(arr, target, idx + 1, ans, temp, sum);

        // Include Choice
        if (arr[idx] + sum <= target) {
            temp.add(arr[idx]);
            sum += arr[idx];
            fun(arr, target, idx, ans, temp, sum);
            sum -= arr[idx];
            temp.remove(temp.size() - 1);
        }
        return;
    }
}
