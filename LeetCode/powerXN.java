public class powerXN {
    public static void main(String[] args) {
        int n=10;
        double x=2;
        double result=myPow(x,n);
        System.out.println(result);

    }
    public static double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            x = 1 / x;
           
            return x * myPow(x, Integer.MAX_VALUE);  
        }
        if(n==0)return 1;
        if(n<0){
            return myPow(1/x,-n);
        }
        double half=myPow(x,n/2);
        if(n%2==0){
            return half*half;
        }
        else{
            return half*half*x;
        }

        // double ans=1;
        // double curr=x;
        // while(n>0){
        //     if(n%2==1){
        //         ans=ans*curr;
        //     }
        //     curr*=curr;
        //     n/=2;
        // }
        // return ans;
    }
}
