 
public class Binomial_Coefficient {
    public static void main(String[] args) {
        int n = 70;
        int k = 50;
    //    System.out.println(binomialCoefficient(n, k));
       System.out.println(binomialCoefficientDP(n, k));
       System.out.println(binomialCoefficientDPSpaceOptimized(n, k));
    }
    public static int binomialCoefficient(int n, int k) {
        if(k==n||k==0) return 1;
        return binomialCoefficient(n-1, k-1)+binomialCoefficient(n-1,k);
    }
    public static int binomialCoefficientDP(int n, int k) {
        int[][] dp=new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=Math.min(i,k);j++){
                if(j==0||j==i) dp[i][j]=1;
                else dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
        return dp[n][k];
    }
    public static int binomialCoefficientDPSpaceOptimized(int n, int k) {
        int[] arr=new int[k+1];
        arr[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,k);j>0;j--){
                arr[j]=arr[j]+arr[j-1];
            }
        }
        return arr[k];
    }
    


}
