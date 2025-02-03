 
public class calc_power {
    public static void main(String[] args) {
        double x=2;
        int n=3;
        System.out.println(myPowIter(x,n)); // Output: 8.0
        System.out.println(myPowRec(x,n)); // Output: 8.0
        
    }
    public static double myPowRec(double x, int n) {
        if(n==Integer.MIN_VALUE){
            x = 1 / x;
           
            return x * myPowRec(x, Integer.MAX_VALUE);
        }
        if(n==0)return 1;
        if(n<0){
            return myPowRec(1/x,-n);
        }
        double res=myPowRec(x,n/2);
        if(n%2==1){
            return (res*res*x);
        }
        else return res*res;
    }
    public static double myPowIter(double a, int b) {
         
         if (b < 0) {
            a = 1 / a;
            b = -b; 
        }
        double ans=1;
        while(b>0){
            if(b%2==1){
                ans=ans*a;
            }
            a=a*a;
            b>>=1;
        }
        return ans;
    }
}
