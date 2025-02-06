import java.util.*;

public class GraphAdjacencyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of edges
        int maxNode = 0;
        
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            maxNode = Math.max(maxNode, Math.max(arr[i][0], arr[i][1]));
        }
        
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= maxNode; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int i = 0; i < n; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Undirected graph
        }

        sc.close(); // Close scanner
        
        // Print adjacency list (for debugging)
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
    }
}
