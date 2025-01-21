import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;
    static final int SZ = 1005;

    public static void main(String[] args) {
        long[][] c = new long[SZ][SZ];
        for (int i = 0; i < SZ; i++) {
            c[i][0] = 1; 
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD; 
            }
        }

        Scanner scanner = new Scanner(System.in);

        // Input the number of groups
        int n = scanner.nextInt();
        long total = 0;
        long ans = 1;

        while (n-- > 0) {
            long x = scanner.nextLong(); 
            ans = (ans * c[(int) (total + x - 1)][(int) (x - 1)]) % MOD;
            total += x;
        }

        // Output the result
        System.out.println(ans);
        scanner.close();
    }
}
