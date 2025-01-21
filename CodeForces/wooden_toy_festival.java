import java.util.*;
import java.util.Scanner;

public class wooden_toy_festival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=sc.nextInt();
            Arrays.sort(arr);
            reverse(arr);
            int lo=0;
            int hi=1000000009;
            int ans=1000000009;
            while(lo<=hi){
                int mid=lo+(hi-lo)/2;
                if(solve(mid,arr)){
                    ans=mid;
                    hi=mid-1;
                }
                else{
                    lo=mid+1;

                }
            }
            System.out.println(ans);
    
        }
    }
    public static boolean solve(int target,int[] arr){
       List<Integer>ls=new ArrayList<Integer>();
       int val=arr[0]-target;
       ls.add(val);
       for(int i=1;i<arr.length;i++){
            if(Math.abs(val-arr[i])>target){
                val=arr[i]-target;ls.add(val);
            }
       }
       if(ls.size()<=3)return true;
       return false;

    }
    public static void reverse(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    
}