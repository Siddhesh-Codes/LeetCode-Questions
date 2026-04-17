import java.util.*;

public class LC_90_Subset_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();

        List<List<Integer>> res = sol.subsetsWithDup(nums);
        System.out.println(res);
    }
}

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        fun(0, nums, list, temp, nums.length);

        return list;
    }

    public void fun(int idx, int[] nums, List<List<Integer>> list, List<Integer> temp, int n) {
        list.add(new ArrayList<>(temp));
        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            // Include
            temp.add(nums[i]);
            fun(i + 1, nums, list, temp, n);
            // Exclude
            temp.remove(temp.size() - 1);
        }
    }
}
