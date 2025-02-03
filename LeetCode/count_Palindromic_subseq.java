import java.util.Arrays;

public class count_Palindromic_subseq {
    public static void main(String[] args) {
        String s = "103301";
        System.out.println(countSubstrings(s));
    }
    public static int mod=(int)1e9+7;
    public static int ct=0;
    public static int countSubstrings(String s) {

        int n=s.length();
        backtrack(s.toCharArray(),0);
        return ct;

        
    }
    public static void backtrack(char[] arr,int idx){
        if(idx==5){
            if(isP(new String(arr))){
                System.out.println(Arrays.toString(arr));
                ct++;
            }
        }
        for(int i=idx;i<arr.length;i++){
            swap(arr,i,idx);
            backtrack(arr,idx+1);
            swap(arr,idx,i);
        }
    }
    public static boolean isP(String s){
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
    public static void swap(char[] nums,int i,int j){
        char temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
