
public class edit_DIstance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(edit_DIstance(word1, word2));
    }
    public static int edit_DIstance(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        for (int i=0;i<=m;i++) {
            dp[i][0]=i;
        }
        for (int j=0;j<=n;j++) {
            dp[0][j]=j;
        }
         
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int del=dp[i-1][j]+1;
                    int insert=dp[i][j-1]+1;
                    int replace=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(del,Math.min(insert,replace));
                }
            }
        } 
        return dp[m][n];
    }
}
