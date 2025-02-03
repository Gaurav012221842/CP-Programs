public class Digit_Dp {
    public static void main(String[] args) {
        int n = 123; 
        String str = String.valueOf(n);
        System.out.println(count(0, true, str, '\0', true));
    }

    public static int count(int idx, boolean tight, String str, char prev, boolean leadingZero) {
        if (idx >= str.length()) return 1;

        char up = tight ? str.charAt(idx) : '9';
        int ans = 0;

        for (char ch = '0'; ch <= up; ch++) {
            if (leadingZero || ch != prev) {  
                ans += count(idx + 1, tight && ch == up, str, ch, leadingZero && ch == '0');
            }
        }
        return ans;
    }
}
