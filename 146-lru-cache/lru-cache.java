class Node{
    int key ;
    int value;
    Node prev;
    Node next;
    public Node(int key , int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    public int cap ;
    public HashMap<Integer,Node> cache;
    Node right;
    Node left;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.right = new Node(0,0);
        this.left = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    public void remove(Node node){
        Node pre = node.prev;
        Node nxt = node.next;
        pre.next = nxt;
        nxt.prev = pre;
    }
    public void insert(Node node){
        Node pre = this.right.prev;
        pre.next = node;
        node.prev = pre;
        node.next = this.right;
        this.right.prev = node;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        insert(node);

        if(cache.size()>cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */