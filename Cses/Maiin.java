import java.util.*;

public class Maiin {
    public static int[] c;
    public static int[] dp;
    public static int f(int amount){
        if(amount<0)return Integer.MAX_VALUE;
        if(amount==0)return 0;
        if(dp[amount]!=-1)return dp[amount];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<c.length;i++){
            if(amount>=c[i]){
                ans=Math.min(ans,f(amount-c[i]));
            }
        }
        if(ans==Integer.MAX_VALUE){
            return dp[amount]=Integer.MAX_VALUE;
        }
        return dp[amount]=1+ans;
    }
    public static int coinChange(int[] coins, int amount) {
        c=coins;
        dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=f(amount);
        return (ans==Integer.MAX_VALUE)?-1:ans;        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int[] coins=new int[n];
        for(int i=0;i<n;i++)coins[i]=sc.nextInt();
       
        System.out.println(coinChange(coins, target));
        
    }
}
