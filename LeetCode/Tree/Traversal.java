import java.util.*;
class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }

}
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
    static int ans=-1;
    static int diam(TreeNode root){
        if(root==null)return 0;
        int lst=diam(root.left);
        int rst=diam(root.right);
        ans=Math.max(ans,lst+rst);
        return 1+Math.max(lst,rst);
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        ans=-1; 
        diam(root);
        return ans;
    }
    public static List<List<Integer>> Narray(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int x=q.size();
            List<Integer>ls=new ArrayList<>();
            for(int i=0;i<x;i++){
                TreeNode curr=q.poll();
                ls.add(curr.val);
                // for(TreeNode child : curr.children){ 
                //     if(child!=null)q.add(child); 
                // }
            }
            res.add(ls);
        }
        return res;

    }
    public static List<List<Integer>> verticalOrderTraversal(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode>q=new LinkedList<>();
        TreeMap<Integer,List<Integer>>map=new TreeMap<>();
        q.add(root);
        while(!q.isEmpty()){
            int x=q.size();
            for(int i=0;i<x;i++){
                TreeNode curr=q.poll();
                int key=curr.val;
                if(!map.containsKey(key))map.put(key,new ArrayList<>());
                map.get(key).add(curr.val);
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
        for(List<Integer> ls : map.values()){
            res.add(ls);
        }
        return res;
        
    }
    
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer>ls=new ArrayList<>();
        f(root,0,ls);
        return ls;
    }
    public static void f(TreeNode root,int level,List<Integer>ls){
        if(root==null)return;
        if(level==ls.size())ls.add(root.val);
        f(root.right,level+1,ls);
        f(root.left,level+1,ls);
    }
    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer>ls=new ArrayList<>();
        ff(root,0,ls);
        return ls;
    }
    public static void ff(TreeNode root,int level,List<Integer>ls){
        if(root==null)return;
        if(level==ls.size())ls.add(root.val);
        f(root.left,level+1,ls);
        f(root.right,level+1,ls);
    }
    public static TreeNode lca(TreeNode root,int p,int q) {
        if(root==null)return root;
        if(root.val==p||root.val==q)return root;
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        if(left==null)return right;
        if(right==null)return left;
        return root;
    }
    public static int maxWidth(TreeNode root){
        if(root==null)return 0;
        int res=0;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().idx;
            int f=0,l=0;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                int index=curr.idx-min;
                if(i==0)f=index;
                if(i==size-1)l=index;
                if(curr.node.left!=null)q.add(new Pair(curr.node.left,2*index+1));
                if(curr.node.right!=null)q.add(new Pair(curr.node.right,2*index+2));
            }
            res=Math.max(res,l-f+1);
        }
        return res;

        
    }
    public static TreeNode helper(int[] preorder,int[] inorder,int st,int end,int[] idx){
        if(st>end)return null;
        int rootval=preorder[idx[0]];
        int i=st;
        for(;i<=end;i++){
            if(inorder[i]==rootval)break;
        }
        idx[0]++;
        TreeNode root=new TreeNode(rootval);
        root.left=helper(preorder,inorder,st,i-1,idx);
        root.right=helper(preorder,inorder,i+1,end,idx);
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        int[] idx={0};
        return helper(preorder,inorder,0,n-1,idx);
    }
    public static boolean isSymmetric(TreeNode root) { 
        if(root==null)return true;
        return isMirror(root.left,root.right);
        
        
    }
    public static boolean isMirror(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
         if(left==null||right==null)return false;
        if(left.val!=right.val)return false;
        return isMirror(left.left,right.right)&&isMirror(left.right,right.left);
    }
    public static boolean isIsomorphic(TreeNode left,TreeNode right) { 
         
            // code here.
             if(left==null&&right==null)return true;
             if(left==null||right==null)return false;
            if(left.val!=right.val)return false;
            return (isIsomorphic(left.left,right.left)&&isIsomorphic(left.right,right.right))||
            (isIsomorphic(left.left,right.right)&&isIsomorphic(left.right,right.left));
        
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        if(p.val!=q.val)return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    public static ArrayList<Integer> findCommon(TreeNode r1, TreeNode r2) {
        // code here
        Stack<TreeNode>s1=new Stack<>();
        Stack<TreeNode>s2=new Stack<>();
        ArrayList<Integer>res=new ArrayList<>();
        while(true){
            while(r1!=null){
                s1.push(r1);
                r1=r1.left;
            }
            while(r2!=null){
                s2.push(r2);
                r2=r2.left;
            }
            if(s1.isEmpty()||s2.isEmpty())break;
            r1=s1.peek();
            r2=s2.peek();
            if(r1.val==r2.val){
                res.add(r1.val);
                s1.pop();s2.pop();
                r1=r1.right;
                r2=r2.right;
                
            }
            else if(r1.val<r2.val){
                s1.pop();
                r1=r1.right;
                r2=null;
            }
            else{
                s2.pop();
                r2=r2.right;
                r1=null;
            }
        }
        return res;
    }
    public static TreeNode bstFromPreorder(int[] pre ) {
        TreeNode root=new TreeNode(pre[0]);
        for(int i=1;i<pre.length;i++){
            insertIntoBST(root,pre[i]);
        }
        return root;
        // return helper(preorder,0,preorder.length-1);
    }
    public static void insertIntoBST(TreeNode root,int val){
      if(root==null)root=new TreeNode(val);
        if(root.val>val){
            if(root.left==null){
                root.left=new TreeNode(val);
            }
            else insertIntoBST(root.left,val);
        }
        else{
            if(root.right==null){
                root.right=new TreeNode(val);
            }
            else insertIntoBST(root.right,val);
        }
       
    }
    public static TreeNode helper(int[] pre,int low,int high){
        if (low > high) return null; 
        TreeNode root = new TreeNode(pre[low]); 
        if (low == high)
            return root; 
        int i;
        for (i = low + 1; i <= high; i++) {
            if (pre[i] > root.val)
                break;
        } 
        root.left = helper(pre, low + 1, i - 1);
        root.right = helper(pre, i, high); 
        return root;
    }
    public static void deleteNodeInBST(TreeNode root,int val){
        if(root==null)return;
        if(root.val>val){
            deleteNodeInBST(root.left,val);
        }
        else if(root.val<val){
            deleteNodeInBST(root.right,val);
        }
        else{
            if(root.left==null){
                root=root.right;
            }
            else if(root.right==null){
                root=root.left;
            }
            else{
                TreeNode min=root.right;
                while(min.left!=null){
                    min=min.left;
                }
                root.val=min.val;
                deleteNodeInBST(root.right,min.val);
            }
        }
    }
    

}

