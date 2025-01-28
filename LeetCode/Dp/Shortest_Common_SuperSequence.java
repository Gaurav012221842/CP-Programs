
public class Shortest_Common_SuperSequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder scs=new StringBuilder();
        String lcs=llcs(str1,str2);
        int i=0;int j=0;
        for(char ch: lcs.toCharArray()){
            while(i<str1.length()&&str1.charAt(i)!=ch){
                scs.append(str1.charAt(i));
                i++;
            }
            while(j<str2.length()&&str2.charAt(j)!=ch){
                scs.append(str2.charAt(j));
                j++;
            }
            scs.append(ch);
            i++;j++;
        }
        scs.append(str1.substring(i));
        scs.append(str2.substring(j));
        return scs.toString();
    }
    public static String llcs(String s,String t){
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int x=m;int y=n;
        while(x>0&&y>0){
            if(s.charAt(x-1)==t.charAt(y-1)){
                sb.append(s.charAt(x-1));
                x--;
                y--;
            }
            else{
                if(dp[x][y-1]<dp[x-1][y]){
                    x--;
                }
                else{
                    y--;
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }
}
