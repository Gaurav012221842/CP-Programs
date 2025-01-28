import java.util.*;

public class subsets {
    public static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> subsets = call(arr);
        System.out.println(subsets);
    }
    public static List<List<Integer>> call(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    public static void  helper(int[] nums, int start,ArrayList<Integer>curr){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            helper(nums, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}