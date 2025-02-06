import java.util.HashMap;
import java.util.Map;

public class Binary_Camera {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
       
        
    }
    static Map<TreeNode, int[]> memo = new HashMap<>();
    public static int minCameraCover(TreeNode root) {
        return f(root, 1);
    }
    public static  int f(TreeNode node, int pc) {
        if (node == null) return 0;
        if (memo.containsKey(node) && memo.get(node)[pc] != -1) {
            return memo.get(node)[pc];
        }
        int ans = Integer.MAX_VALUE;
        if (pc == 2) {
            ans = Math.min(1 + f(node.left, 2) + f(node.right, 2), f(node.left, 1) + f(node.right, 1));
        } else if (pc == 1) {
            ans = 1 + f(node.left, 2) + f(node.right, 2);
            if (node.left != null) {
                ans = Math.min(ans, f(node.left, 0) + f(node.right, 1));
            }
            if (node.right != null) {
                ans = Math.min(ans, f(node.right, 0) + f(node.left, 1));
            }
        } else {
            ans = 1 + f(node.right, 2) + f(node.left, 2);
        } 
        memo.putIfAbsent(node, new int[]{-1, -1, -1});
        memo.get(node)[pc] = ans; 
        return ans;
    }
}
