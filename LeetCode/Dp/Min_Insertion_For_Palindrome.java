
public class Min_Insertion_For_Palindrome {
    public static void main(String[] args) {
        String s = "mbadm";
        System.out.println(minInsertions(s));

    }
    public static  int minInsertions(String s) {
        int n=s.length();
        String t=rev(s);
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[n][n];
    }
    public static String rev(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
