
import java.util.*;
public class Dijkastra {
    class iPair {
        int first, second;
    
        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public class Pair implements Comparable<Pair>{
        int n;int path;
        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int[] dist=new int[adj.size()];
        boolean[] vis=new boolean[adj.size()];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));
        for(int i=0;i<adj.size();i++){
            if(i!=src)dist[i]=Integer.MAX_VALUE;
        }
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
               for (iPair edge : adj.get(curr.n)) {
                    int v = edge.first; 
                    int weight = edge.second;  
                    if (dist[curr.n] + weight < dist[v]) {
                        dist[v] = dist[curr.n] + weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<dist.length;i++){
            res.add(dist[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}
