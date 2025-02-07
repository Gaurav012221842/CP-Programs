import java.util.Arrays;

public class Kth_Ancestor {
    public static int table[][];
    public static int height;
    public Kth_Ancestor(int n){
        height=(int)Math.ceil(Math.log(n)/Math.log(2));
        table=new int[n+1][height+1];
    }
    public static void preprocessing(){
        for(int i=0;i<=height;i++){
            Arrays.fill(table[i],-1);
        }
    }
    public static void calculateSparse(int u,int v){
        table[v][0]=u;
        for(int i=1;i<=height;i++){
            table[v][i]=table[table[v][i-1]][i-1];
            if(table[v][i]==-1)break;
        }
    
    }
    private static int kthancestor(int V, int k)
    {
 
        for (int i = 0; i <= height; i++) {
            if ((k & (1 << i)) != 0) {
                V = table[V][i];
                if (V == -1)
                    break;
            }
        }
        return V;
    }
    public static void main(String[] args) {
        int n=6;
        Kth_Ancestor obj=new Kth_Ancestor(n);
        preprocessing();
        calculateSparse(1, 2);
        calculateSparse(1, 3);
        calculateSparse(2, 4);
        calculateSparse(2, 5);
        calculateSparse(3, 6);
        System.out.println(kthancestor(4, 2));

    }

}
