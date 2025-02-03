import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor with value only
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    // Constructor with value and child nodes
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Traversal {
    public static void main(String[] args) {
         TreeNode root = new TreeNode(10);
         root.left = new TreeNode(9);
         root.right = new TreeNode(12);
         root.left.left = new TreeNode(7);
         root.left.right = new TreeNode(8);
         root.right.left = new TreeNode(13);
         root.right.right = new TreeNode(14);
         System.out.println("\nPreorder traversal:");
         System.out.println(preorderTraversal(root));
         System.out.println("\nInorder traversal:");
         System.out.println(inOrderTraversal(root));
         System.out.println("\nPostorder traversal:");
         System.out.println(postorderTraversal(root));
         System.err.println("Level Order Traversal");
         System.out.println(levelOrderTraversal(root));
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.println(root.val);
    }
     public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) return ans; 
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            ans.add(curr.val); 
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }
        return ans;
    }
     public static List<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !s.isEmpty()) { 
            while (curr != null) { 
                s.push(curr);
                curr = curr.left;
            } 
            curr = s.pop();
            ans.add(curr.val); 
            curr = curr.right;
        } 
        return ans;
    }
    
     public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) return ans; 
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            ans.add(curr.val); 
            if (curr.left != null) {
                s.push(curr.left);
            }
            if (curr.right != null) {
                s.push(curr.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
     public static List<Integer> levelOrderTraversal(TreeNode root) {   
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                ans.add(curr.val);
                if (curr.left!= null) {
                    queue.add(curr.left);
                }
                if (curr.right!= null) {
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }
}
