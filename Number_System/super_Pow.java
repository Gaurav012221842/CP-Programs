 
public class super_Pow {
    public static void main(String[] args) {
        int a=2;
        int[] b={1,0,9};
        System.out.println(superPow(a, b)); // Output: 1024
        
    }
    public static int superPow(int a, int[] b) {
        int bmod=0;
        for(int val:b){
            bmod=(bmod*10+val)%1140;
        }
        if(bmod==0)bmod=1140;
        return myPow(a,bmod,1337);
    }
     public static int myPow(int a, int b,int m) {
        a%=m; 
        int ans=1;
        while(b>0){
            if(b%2==1){
                ans=(ans*a)%m;
            }
            a=(a*a)%m;
            b>>=1;
        }
        return ans;
    }
}
