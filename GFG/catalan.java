import java.util.Arrays;

public class catalan {
    static int mod=1000000007;
    public static void main(String[] args) {
        int n=43;
        System.out.println(catalann(n));
       
    }
    
    
    public static int catalann(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int summ=0;
            for(int j=0;j<i;j++){
                summ += (dp[j] * dp[i - 1 - j]) % mod;
                summ %= mod;
            }
            dp[i]=summ;
        }
         
        return dp[n];
    }
}
