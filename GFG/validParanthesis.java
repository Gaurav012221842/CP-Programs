public class validParanthesis {
    public static int mod=1000000007;
    public static void main(String[] args) {
        int max=1000;
        int[] catalan = precompute(max);
        int n = 980;
        if (n % 2 != 0) {
            System.out.println(-1);  
        } else {
            System.out.println(catalan[n / 2]);  
        }
    }
    public static int[] precompute(int n) {
        int[] dp=new int[(n/2)+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n/2;i++){
            long summ=0;
            for(int j=0;j<i;j++){
                summ += (1L*dp[j] * dp[i - 1 - j]) % mod;
                summ %= mod;
            }
            dp[i]=(int)summ;
        }
        return dp;
    }
}
