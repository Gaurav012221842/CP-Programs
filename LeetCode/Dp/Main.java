import java.util.Scanner;

public class Main {
    public static String longestPalindromicSubstring(String s) {
        if (s.isEmpty()) return "";

        // Transform the string to handle even-length palindromes
        StringBuilder t = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            t.append(c).append("#");
        }
        String transformed = t.toString();
        
        int n = transformed.length();
        int[] p = new int[n];  // Array to store palindrome lengths
        int center = 0, right = 0;  // Center and right boundary of the palindrome

        int maxLength = 0, startIndex = 0;

        for (int i = 0; i < n; i++) {
            // Mirror index of i around the current center
            int mirror = 2 * center - i;
            
            if (i < right)
                p[i] = Math.min(right - i, p[mirror]);

            // Expand around center
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n && transformed.charAt(i - p[i] - 1) == transformed.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Track the longest palindrome
            if (p[i] > maxLength) {
                maxLength = p[i];
                startIndex = (i - maxLength) / 2;  // Convert back to original string index
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(longestPalindromicSubstring(s));
        scanner.close();
    }
}
