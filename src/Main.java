public class Main {
    public static void main(String[] args) {

        int CAPACITY = 5;
        LRUCache lruCache = new LRUCache(CAPACITY);

        lruCache.put(2,3);
        int val = lruCache.get(2);
        System.out.println("val: $" + val);
    }
}
