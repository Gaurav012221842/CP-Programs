import java.util.*;

public class Dice_combination {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Test with the given large input
        int res = countWays(n);
        System.out.println(res);
    }

    public static int countWays(int n) {
        int[] dp = new int[n + 1]; 
        dp[0] = 1; 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }

        return dp[n];  
    }
}
// import java.util.*;

// public class Main {
//     static final int MOD = 1000000007;

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = 123456; // Test with the large input
//         int res = countWays(n, new int[n + 1]); // Pass a memoization array
//         System.out.println(res);
//     }

//     public static int countWays(int n, int[] memo) {
//         if (n == 0) return 1; // Base case: 1 way to get sum 0 (no dice rolls)
//         if (n < 0) return 0;  // No way to get a negative sum
        
//         if (memo[n] != 0) return memo[n]; // Return already calculated result
        
//         int ans = 0;
//         for (int j = 1; j <= 6; j++) { // Dice rolls from 1 to 6
//             ans = (ans + countWays(n - j, memo)) % MOD; // Recursive call
//         }
        
//         memo[n] = ans; // Store result in memo array
//         return ans;
//     }
// }
