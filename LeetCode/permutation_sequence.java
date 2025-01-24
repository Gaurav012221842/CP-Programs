import java.util.ArrayList;
import java.util.List;

public class permutation_sequence {

     
    public String getPermutation(int n, int k) {
        // Generate the initial list of numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Compute factorial values
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Adjust k to be zero-indexed
        k--;

        // Build the k-th permutation
        StringBuilder result = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial[i - 1];
        }

        return result.toString();
    }

    public static void main(String[] args) {
        permutation_sequence ps = new permutation_sequence();
        System.out.println(ps.getPermutation(32, 13));  
        System.out.println(ps.getPermutationn(32, 13));  
    }
    public static String getPermutationn(int n, int k) {
        String s="";
        for(int i=1;i<=n;i++){
            s+=i+"";
        }
        while(k-->1){
            s=nextPermutation(s); 
        }
        return s;

         
    }
    public static String nextPermutation(String str) {
        int[] arr=new int[str.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=str.charAt(i)-'0';
        }
        int n = arr.length; 
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }
 
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
             
        }else{

        // Find the element from the right that is greater than pivot
            for (int i = n - 1; i > pivot; i--) {
                if (arr[i] > arr[pivot]) {
                    swap(arr, i, pivot);
                    break;
                }
            }
            reverse(arr, pivot + 1, n - 1); 
        }

        StringBuilder result = new StringBuilder();
        for (int num : arr) {
            result.append(num);
        }
        return result.toString();
    }

    // Helper method to reverse array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}