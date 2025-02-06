import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] adjList; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); 
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        } 
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(b);
            adjList[b].add(a);
        } 
        int farthestNode = bfs(1)[1]; 
        int diameter = bfs(farthestNode)[0]; 
        System.out.println(diameter);
    }
    static int[] bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];  

        queue.add(start);
        visited[start] = true;
        dist[start] = 0;
        int farthestNode = start, maxDist = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                    if (dist[neighbor] > maxDist) {
                        maxDist = dist[neighbor];
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{maxDist, farthestNode}; 
    }
}
