import java.util.Scanner;

public class removing_digits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int st=0;
        while(n!=0){
            int x=crt(n);
            n=n-x;
            st++;
        }
        System.out.println(st);
    }
    public static int crt(int n){
        int max=-11;
        while(n>0){
            max=Math.max(max,n%10);
            n/=10;
        }
        return max;
    }
}
