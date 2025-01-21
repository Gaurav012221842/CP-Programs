public class TOH {
    static int count=0;
    public static void main(String[] args) {
        int n=4;
        towerOfHanoi(n, 'A', 'C', 'B');
        System.out.println(count);
    }
        public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
            if (n > 0) {
                towerOfHanoi(n - 1, source, auxiliary, destination);
                System.out.println("Move disk " + n + " from rod " + source + " to rod " + destination);count++;
                towerOfHanoi(n - 1, auxiliary, destination, source);
            }
        }

    
}
