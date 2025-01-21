
public class smallestGoodBase {
    public static void main(String[] args) {
        String str="1000000000000000000";
        System.out.println(smallestGoodBase(str));
    }
    public static  String smallestGoodBase(String num) {
        Long n=Long.parseLong(num);
        for(int i=63;i>0;i--){
            long lo=2;
            long hi=n-1;
            while(lo<=hi){
                long mid=lo+(hi-lo)/2;
                long sum=0;long x=1;
                boolean flag=false;
                for(int j=0;j<=i;j++){
                    sum+=x;
                    if(sum>=n){break;}
                    if(j<i&&(n-sum)/mid<x){flag=true;break;}
                    if(j<i)x*=mid;
                }
                if(sum>n||flag)hi=mid-1;
                else if(sum<n)lo=mid+1;
                else return Long.toString(mid);
            }
        }
        return "";
    }
}
