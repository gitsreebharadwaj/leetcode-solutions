class LRUCache {
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key=key;
            this.val=val;
        }
    }
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;
    private int capacity;
    public LRUCache(int capacity) {
        this.map=new HashMap<>();
        this.head=new Node(-1, -1);
        this.tail=new Node(-1, -1);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node temp=map.get(key);
        deleteNode(temp);
        insertAtFirst(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node temp=map.get(key);
            temp.val=value;
            deleteNode(temp);
            insertAtFirst(temp);
        }
        else {
            if(map.size()==capacity) {
                Node lruNode=deleteAtTail();
                map.remove(lruNode.key);
            }
            Node newNode=new Node(key, value);
            insertAtFirst(newNode);
            map.put(key, newNode);
        }
    }
    void insertAtFirst(Node node) {
        Node nextNode=head.next;
        head.next=node;
        node.prev=head;
        node.next=nextNode;
        nextNode.prev=node;
    }
    void deleteNode(Node node) {
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
    Node deleteAtTail() {
        Node lruNode=tail.prev;
        deleteNode(lruNode);
        return lruNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
