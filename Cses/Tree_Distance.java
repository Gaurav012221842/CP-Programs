import java.util.Scanner;
import java.util.*;;
public class Tree_Distance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n-1][2];
        for(int i=0;i<n-1;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        List<List<Integer>>ls=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            ls.add(new ArrayList<Integer>());
        }
        for(int[] ar: arr){
            System.out.println(findDist(ar[0], ar[1], ls, new boolean[n]));
        } 

    }
    
    public static int findDist(int node1, int node2, List<List<Integer>> ls, boolean[] visited){
        visited[node1]=true;
        if(node1==node2)return 0;
        int dis=0;
        for(int i=0;i<ls.get(node1).size();i++){
            int child=ls.get(node1).get(i);
            if(!visited[child]){
                dis=1+findDist(child,node2,ls,visited);
                if(dis!=0)break;
            }
        }
        visited[node1]=false;
        return dis;
    }
    
}
