import java.util.*;
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value){
        this.key=key;this.value=value;this.prev=null;this.next=null;
    }
}
class LRUCache{
    private int capacity;
    private Map<Integer,Node> cache;
    private Node head;
    private Node tail; 
    public LRUCache(int capacity){
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node=cache.get(key);
        removeNode(node);
        addNode(node);
        return node.value;
    }
    public void put(int key, int value){
        if(cache.containsKey(key)){
            Node Oldnode=cache.get(key);
            removeNode(Oldnode);
        }
        Node Newnode=new Node(key, value);
        cache.put(key, Newnode);
        addNode(Newnode);
        if(cache.size()>capacity){
            Node removeNode=tail.prev;
            removeNode(removeNode);
            cache.remove(removeNode.key);
        }
    }
    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    private void addNode(Node node){
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }   
}
public class LRU_Cache {
   public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));       // returns 1
   }
}
