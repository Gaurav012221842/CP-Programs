import java.util.Arrays;
public class MCM {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minCost(arr));
    }
    public static int minCost( int[] cuts) {
       int n=cuts.length;
        int[][] memo=new int[n][n];
        for(int[] mem:memo)Arrays.fill(mem,-1);
        return call(cuts,0,n-1,memo);
    }
    public static int call(int[] cuts,int i,int j,int[][] memo){
        if(i+1==j){
            return 0;
        }
        if(memo[i][j]!=-1)return memo[i][j];
        int res=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int r=call(cuts,i,k,memo)+call(cuts,k,j,memo)+cuts[i]*cuts[k]*cuts[j];
            res=Math.min(r,res);
        }
        memo[i][j]=res;
        return res;
    }
}
