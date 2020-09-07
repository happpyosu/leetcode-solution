package others;

import java.util.HashMap;

// todo
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));     // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));   // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));      // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));        // 返回  4
    }


    private int capacity;

    private final Node head = new Node();
    private final Node tail = new Node();

    private final HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        moveToHead(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToHead(map.get(key));
        }else {
            if(capacity <= 0) {
                dropTail();
            }
            addHead(new Node(key, value));
        }
    }

    private void moveToHead(Node node){
        Node node_prev = node.prev;
        Node node_next = node.next;
        node_prev.next = node_next;
        node_next.prev = node_prev;

        Node head_next = head.next;
        head.next = node;
        node.prev = head;
        head_next.prev = node;

        node.next = head_next;
    }

    private void dropTail(){
        Node node = tail.prev;
        Node node_prev = node.prev;
        tail.prev = node_prev;
        node_prev.next = tail;
        capacity++;
        map.remove(node.key);
    }

    private void addHead(Node node){
        Node node_next = head.next;
        head.next = node;
        node.prev = head;
        node.next = node_next;
        node_next.prev = node;
        capacity--;
        map.put(node.key, node);
    }


}

class Node{
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(){
    }

    public Node(int k, int v){
        key = k;
        val = v;
    }
}
