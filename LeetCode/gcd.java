public class gcd {
    public static void main(String[] args) {
        int x=150,y=15;
        int result=gcd(x,y);
        System.out.println(result);
    }
    public static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
