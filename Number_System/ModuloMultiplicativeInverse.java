 //nCr=n!/((n-r!)*r!)
public class ModuloMultiplicativeInverse {
    static int mod=(int)1e9+7;
    public static void main(String[] args) {
        int a= (int)1e6+10;
        long[] fact=new long[a];
        fact[0]=1;
        for(int i=1;i<a;i++){
            fact[i]=(fact[i-1]*i)%mod;
        }
        int n=80;
        int r=30;
        long ans=fact[n];
        long den=(fact[n-r]*fact[r])%mod;
        ans = (int)((long)ans * binExp(den, mod - 2, mod) % mod);
        System.out.println(ans);

        
    }
    static long binExp(long a,int b,int mod){
        long res=1;
        while(b>0){
            if(b%2==1)
                res=(res*1L*a)%mod;
            a=(a*1L*a)%mod;
            b>>=1;
        }
        return res;
    }

} 
    
 