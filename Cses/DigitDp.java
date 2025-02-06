import java.util.Scanner;
import java.util.Arrays;

public class DigitDp {
    static long[][][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long f = sc.nextLong(); // Use nextLong() instead of nextInt()
        long s = sc.nextLong();

        String high = Long.toString(s);
        String low = Long.toString(f - 1);

        dp = new long[high.length()][2][11][2]; // Use long[][][][] to store large values
        for (long[][][] d1 : dp) {
            for (long[][] d2 : d1) {
                for (long[] d3 : d2) {
                    Arrays.fill(d3, -1);
                }
            }
        }
        long highCount = count(0, 1, high, -1, 1);

        dp = new long[low.length()][2][11][2]; // Reset DP for the low count
        for (long[][][] d1 : dp) {
            for (long[][] d2 : d1) {
                for (long[] d3 : d2) {
                    Arrays.fill(d3, -1);
                }
            }
        }
        long lowCount = count(0, 1, low, -1, 1);

        System.out.println(highCount - lowCount);
    }

    public static long count(int idx, int tight, String str, int prev, int leadingZero) {
        if (idx >= str.length())
            return 1;

        if (dp[idx][tight][prev + 1][leadingZero] != -1)
            return dp[idx][tight][prev + 1][leadingZero];

        char up = tight == 1 ? str.charAt(idx) : '9';
        long ans = 0;

        for (char ch = '0'; ch <= up; ch++) {
            int digit = ch - '0';
            if (leadingZero == 1 || digit != prev) {
                ans += count(idx + 1, tight & (ch == up ? 1 : 0), str, digit, leadingZero & (ch == '0' ? 1 : 0));
            }
        }
        return dp[idx][tight][prev + 1][leadingZero] = ans;
    }
}
