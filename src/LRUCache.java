import java.util.HashMap;
import java.util.Map;

public class LRUCache implements Cache {
    final Node head = new Node(-1,-1);
    final Node tail = new Node(-1,-1);
    Map<Integer,Node> cache_map;
    int cache_capacity;

    public LRUCache(int capacity) {
        cache_map = new HashMap<>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void addNode(Node node) {
        Node temp = head.next;
        node.prev = head;
        node.next = temp;
        head.next = node;
        temp.prev = node;
    }

    @Override
    public void deleteNode(Node node) {
        Node next_node = node.next;
        Node prev_node= node.prev;
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }

    @Override
    public int get(int key) {
        int ans = -1;
        Node node = cache_map.get(key);
        if(node!= null) {
            ans = node.value;
            deleteNode(node);
            addNode(node);
        }
        return ans;
    }

    @Override
    public void put(int key, int value) {
        Cache.super.put(key, value);
        Node node = cache_map.get(key);
        if(node != null){
            deleteNode(node);
            node.value = value;
            addNode(node);
        }
        else {
            if(cache_map.size() == cache_capacity){
                cache_map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            Node new_node = new Node(-1,-1);
            new_node.key = key;
            new_node.value = value;
            cache_map.put(key,new_node);
            addNode(new_node);
        }
    }
}
