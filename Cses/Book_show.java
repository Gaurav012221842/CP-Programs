import java.util.*;
import java.util.Scanner;
public class Book_show {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr=new int[n];
        int[] pages=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            pages[i]=scanner.nextInt();
        }
        int[] dp=new int[target+1];
        for(int i=0;i<n;i++){
            for(int j=target;j>=arr[i];j--){
                dp[j]=Math.max(dp[j],dp[j-arr[i]]+pages[i]);
            }
        }
        System.out.println(dp[target]);
    }
    
      
}
