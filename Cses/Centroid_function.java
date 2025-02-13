import java.io.*;
import java.util.*;

public class Centroid_function {
    static int n;
    static int[] sub;
    static ArrayList<ArrayList<Integer>> ar;

    static void computeSubtreeSize(int root) {
        Stack<int[]> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];

        stack.push(new int[]{root, -1});
        ArrayList<int[]> postOrder = new ArrayList<>();

        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            int u = node[0], parent = node[1];
            postOrder.add(node);

            for (int v : ar.get(u)) {
                if (v != parent && !visited[v]) {
                    stack.push(new int[]{v, u});
                    visited[v] = true;
                }
            }
        }

        for (int i = postOrder.size() - 1; i >= 0; i--) {
            int[] node = postOrder.get(i);
            int u = node[0], parent = node[1];

            sub[u] = 1;
            for (int v : ar.get(u)) {
                if (v != parent) {
                    sub[u] += sub[v];
                }
            }
        }
    }

    static int findCentroid(int root) {
        int half = n / 2;
        boolean[] visited = new boolean[n + 1];
        int node = root, parent = -1;

        while (true) {
            boolean found = false;
            for (int child : ar.get(node)) {
                if (!visited[child] && child != parent && sub[child] > half) {
                    parent = node;
                    node = child;
                    found = true;
                    break;
                }
            }
            if (!found) return node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ar = new ArrayList<>();
        sub = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ar.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ar.get(a).add(b);
            ar.get(b).add(a);
        }

        computeSubtreeSize(1);
        System.out.println(findCentroid(1));
    }
}
