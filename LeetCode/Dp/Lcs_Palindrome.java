 
public class Lcs_Palindrome {
    public int longestPalindromeSubseq(String s) {
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
       return dp[n][n];
   }
   public String rev(String s){
       StringBuilder sb=new StringBuilder(s);
       sb.reverse();
       return sb.toString();
   
   }
   public static void main(String[] args) {
    Lcs_Palindrome l=new Lcs_Palindrome();
    System.out.println(l.longestPalindromeSubseq("abcba"));
   }
}
