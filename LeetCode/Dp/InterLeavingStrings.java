
public class InterLeavingStrings {
    public static void main(String[] args) {
        // String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";//true
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";//false
        System.out.println(isInterleave(s1, s2, s3)); // true
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        Boolean[][] dp=new Boolean[s1.length()+1][s2.length()+1];
        return helper(dp,s1,s2,s3,0,0,0);
    }
    public static boolean helper(Boolean[][] dp,String s,String t,String u,int i,int j,int k){
        if(i+j==u.length()){
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean result=false;
        if(i<s.length()&&s.charAt(i)==u.charAt(k)){
            result=helper(dp,s,t,u,i+1,j,k+1);
        }
        if(!result&&j<t.length()&&t.charAt(j)==u.charAt(k)){
            result=helper(dp,s,t,u,i,j+1,k+1);
        }
        dp[i][j]=result;
        return result;
    }
}
