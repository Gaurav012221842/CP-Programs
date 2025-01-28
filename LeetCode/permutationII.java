import java.util.*;
public class permutationII {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }   
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);   
        boolean[] used = new boolean[nums.length];   
        backtrack(new ArrayList<>(), nums, used);
        return res;
    }
    private static void backtrack(List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) { 
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (used[i]) continue; 
            used[i] = true;
            current.add(nums[i]); 
            backtrack(current, nums, used); 
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
