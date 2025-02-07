import java.util.ArrayList;
import java.util.Stack;

public class Generic_tree {
    // Define a generic tree node
    private static class Node{
        int data;
        ArrayList<Node> children=new ArrayList<>();

    }
    public static void display(Node node){
        String str=node.data+" -> ";
        for(Node child: node.children){
            str+=child.data+" ,";
        }
        str+=".";
        System.out.println(str);
        for(Node child: node.children){
            display(child);
        }
    }
    public static void main(String[] args) {
        int [] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
         Stack<Node>st=new Stack<>();
         Node root=null;
         for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            }
            else{
                Node node=new Node();
                node.data=arr[i];
                if(st.size()>0){

                    st.peek().children.add(node);
                }
                else{
                    root=node;
                }
                st.push(node);

            }

         }
         display(root);
         System.out.println("Size of the tree: "+size(root));
         System.out.println("Maximum value: "+maximum(root));
    }
    public static int size(Node root){
        int size=0;
        for(Node child: root.children){
           int sze=size(child);
            size+=sze;
        }
        return size+1;
    }
    public static int maximum(Node root){
        int max=root.data;
        for(Node child: root.children){
            int m=maximum(child);
            max=Math.max(max,m);
            // max=Math.min(max,m);
        }
        return max;
    }
    public static int height(Node root){
        int max=-1;
        for(Node child: root.children){
            int h=height(child);
            max=Math.max(max,h);
        }
        return max+1;
    }
}
