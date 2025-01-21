import java.util.Arrays;

public class nCr {
    static int mod=1000000007;
    public static void main(String[] args) {
        int n = 123;
        int r = 84;
        System.out.println(nCr(n, r)); 
        System.out.println(nCrr(n, r)); 
         
    }
    static int fact(int n, int mod){
        if(n == 0 || n == 1) return 1;
        return (int)((long) n * fact(n - 1, mod) % mod);
    } 
    static int power(int a, int b, int mod) {
        int result = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                result = (int)((long) result * a % mod);
            }
            a = (int)((long) a * a % mod);
            b >>= 1;
        }
        return result;
    }
    static int modInverse(int a, int mod) {
        return power(a, mod - 2, mod);
    }

    public static int nCr(int n, int r) { 
        if(r > n) return 0;
        
        int mod = 1000000007; 
        int factN = fact(n, mod);
        int factR = fact(r, mod);
        int factNR = fact(n - r, mod);
        
        // Use modInverse to divide in modular arithmetic
        int result = (int)((long) factN * modInverse(factR, mod) % mod * modInverse(factNR, mod) % mod);
         
        
        return result;
        
        
    }
    public static long nCrr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        // Since nCr is symmetric, use the smaller r
        r = Math.min(r, n - r);

        long numerator = 1;
        long denominator = 1;

        for (int i = 0; i < r; i++) {
            numerator = (numerator * (n - i)) % mod;
            denominator = (denominator * (i + 1)) % mod;
        }

        // Compute denominator^(mod-2) % mod using Fermat's Little Theorem
        long denominatorInverse = power(denominator, mod - 2, mod);

        // Return nCr % mod
        return (int) ((numerator * denominatorInverse) % mod);
    }
    
    private static long power(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
      //  System.out.println("Initial base: " + base);
        while (exp > 0) {
       //     System.out.println("Current exp: " + exp + ", result: " + result + ", base: " + base);
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
           //     System.out.println("Updated result after multiplication: " + result);
            }
            base = (base * base) % mod;
          //  System.out.println("Updated base after squaring: " + base);
            exp >>= 1;
        }
        return result;
    }
    
}
