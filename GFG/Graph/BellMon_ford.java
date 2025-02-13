 import java.util.*;
public class BellMon_ford {
    static int[] bellmanFord(int V, int[][] edges, int src) { 
        int[] res=new int[V];
        Arrays.fill(res,(int)1e8);
        res[src]=0;
        for(int i=0;i<V;i++){
            for(int[] ed: edges){
                int u=ed[0];
                int v=ed[1];
                int w=ed[2];
                if(res[u]!=(int)1e8&&res[u]+w<res[v]){
                    res[v]=res[u]+w;
                }
            }
        }
        for(int[] ed: edges){
                int u=ed[0];
                int v=ed[1];
                int w=ed[2];
                if(res[u]!=(int)1e8&&res[u]+w<res[v]){
                    return new int[]{-1};
                }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}
