import java.util.*;
public class combinationSumDuplicate {
    static List<List<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {
         int[] arr={1,2,3,4,5,6,7,8};
         int target=10; 
         backtrack(arr,new ArrayList<>(),target,0);
         System.out.println(result);
    }
    public static void backtrack(int[] arr,List<Integer>ls,int target,int idx){
        if(target==0){
            result.add(new ArrayList<>(ls)); return;
        }
        for(int i=idx;i<arr.length;i++){
            ls.add(arr[i]);
            backtrack(arr,ls,target-arr[i],i+1);
            ls.remove(ls.size()-1);
        }
    }
}
