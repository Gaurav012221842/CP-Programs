import java.util.Scanner;

public class CF227C {
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
         m=sc.nextInt();
        long res=power(3,n);
        res--;
        if(res<0)res+=m;
        System.out.println(res);
        
    }
    public static long power(int num,int deg){
        if(deg==0) return 1;
        if (deg % 2==1)
        {
            return (power(num, deg - 1) * num) % m;        
        }
        else 
        {
            long sqrt_res = power(num, deg / 2);
            return (sqrt_res * sqrt_res) % m;
        }
    }
}
// import java.util.Scanner;

// public class CF227C {

//     static int m;

//     static long power(int num, int deg) {
//         if (deg == 0) {
//             return 1;
//         }
//         if (deg % 2 == 1) {
//             return (power(num, deg - 1) * num) % m;
//         } else {
//             long sqrtRes = power(num, deg / 2);
//             return (sqrtRes * sqrtRes) % m;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         m = sc.nextInt();

//         long res = power(3, n);
//         res--;

//         if (res < 0) {
//             res += m;
//         }

//         System.out.println(res);
//     }
// }
