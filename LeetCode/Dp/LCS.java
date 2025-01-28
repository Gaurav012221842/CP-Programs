import java.util.Arrays;

public class LCS {
    public static int longestCommonSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static  int longestCommonSubsequenceMemo(String text1, String text2) {
        int[][] dp=new int[1005][1005];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return call(text1,text2,0,0,dp);
    }
    public  static int call(String s,String t,int x,int y,int[][]dp){
        if(x>=s.length()||y>=t.length())return 0;
        if(dp[x][y]!=-1)return dp[x][y];
        if(s.charAt(x)==t.charAt(y)){
            return dp[x][y]=1+call(s,t,x+1,y+1,dp);
        }
        else{
            return dp[x][y]=Math.max(call(s,t,x,y+1,dp),call(s,t,x+1,y,dp));
        }
    }
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
}
