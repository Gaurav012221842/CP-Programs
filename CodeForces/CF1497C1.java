package CodeForces;
// It is the easy version of the problem. The only difference is that in this version 𝑘=3
// .

// You are given a positive integer 𝑛
// . Find 𝑘
//  positive integers 𝑎1,𝑎2,…,𝑎𝑘
// , such that:

// 𝑎1+𝑎2+…+𝑎𝑘=𝑛
// 𝐿𝐶𝑀(𝑎1,𝑎2,…,𝑎𝑘)≤𝑛2
// Here 𝐿𝐶𝑀
//  is the least common multiple of numbers 𝑎1,𝑎2,…,𝑎𝑘
// .

// We can show that for given constraints the answer always exists.

// Input
// The first line contains a single integer 𝑡
//  (1≤𝑡≤104)
//   — the number of test cases.

// The only line of each test case contains two integers 𝑛
// , 𝑘
//  (3≤𝑛≤109
// , 𝑘=3
// ).

// Output
// For each test case print 𝑘
//  positive integers 𝑎1,𝑎2,…,𝑎𝑘
// , for which all conditions are satisfied.

// Example
// InputCopy
// 3
// 3 3
// 8 3
// 14 3
// OutputCopy
// 1 1 1
// 4 2 2
// 2 6 6
import java.util.Scanner;
public class CF1497C1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x=sc.nextInt(); 
            if(x%2!=0){
                System.out.println("1"+" "+x/2+" "+x/2);
            }
            else if(x%2==0&&x%4==0){
                System.out.println(x/2+" "+x/4+" "+x/4);
            }
            else{
                System.out.println("2 "+(x/2-1)+" "+(x/2-1));
            }
        }
    }  
    public static int lcm(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    } 
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
}
