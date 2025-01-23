import java.util.ArrayList;
import java.util.List;

public class permutations {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(0, nums);
        return res;
    }
    public void backtrack(int idx,int[] nums){
        if(idx==nums.length){
            List<Integer> lis = new ArrayList<>();
            for(int xx:nums){
                lis.add(xx);
            }
            res.add(new ArrayList<>(lis));
            return ;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            backtrack(idx+1,nums);
            swap(nums,idx,i);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        permutations p=new permutations();
        List<List<Integer>> result=p.permute(nums);
        for(List<Integer> x:result){
            System.out.println(x);
        }
    }
}
