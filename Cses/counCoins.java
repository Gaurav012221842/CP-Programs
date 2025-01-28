import java.util.*;
import java.util.Scanner;
public class counCoins {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] coins=new int[n];
       
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        int res=countCoins(coins,target);
        System.out.println(res);
    }
    public static int countCoins(int[] coins,int target){
        int[] dp=new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=target;i++){
            for(int coin:coins){
                if(coin<=i&& dp[i - coin] != Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[target]==Integer.MAX_VALUE?-1:dp[target];
    }
     
}
