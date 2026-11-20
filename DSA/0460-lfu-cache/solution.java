class LFUCache {
    private static class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key=key;
            this.val=val;
            this.freq=1;
        }
    }
    private final Map<Integer, Node> freqToHead;
    private final Map<Integer, Node> freqToTail;
    private final Map<Integer, Node> keyToNode;
    private final int capacity;
    private int minFreq;
    public LFUCache(int capacity) {
        this.freqToHead=new HashMap<>();
        this.freqToTail=new HashMap<>();
        this.keyToNode=new HashMap<>();
        this.capacity=capacity;
        this.minFreq=0;
    }
    
    public int get(int key) {
        if(capacity<=0 || !keyToNode.containsKey(key)) {
            return -1;
        }
        Node temp=keyToNode.get(key);
        updateFrequency(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(capacity<=0) {
            return;
        }
        if(keyToNode.containsKey(key)) {
            Node temp=keyToNode.get(key);
            temp.val=value;
            updateFrequency(temp);
        }
        else {
            if(keyToNode.size()==capacity) {
                Node headSentinal=freqToHead.get(minFreq);
                Node tailSentinal=freqToTail.get(minFreq);
                Node lfuNode=deleteAtTail(headSentinal, tailSentinal);
                if(lfuNode!=null) {
                    keyToNode.remove(lfuNode.key);
                }
            }
            Node newNode=new Node(key, value);
            keyToNode.put(key, newNode);
            createFrequencyListIfAbsent(1);
            insertAtFirst(freqToHead.get(1), newNode);
            minFreq=1;
        }
    }
    private void updateFrequency(Node node) {
        int oldFreq=node.freq;
        Node oldHead=freqToHead.get(oldFreq);
        Node oldTail=freqToTail.get(oldFreq);
        deleteNode(node);
        if(oldFreq==minFreq && oldHead.next==oldTail) {
            minFreq++;
        }
        node.freq++;
        int newFreq=node.freq;
        createFrequencyListIfAbsent(newFreq);
        insertAtFirst(freqToHead.get(newFreq), node);
    }
    private void createFrequencyListIfAbsent(int freq) {
        if(!freqToHead.containsKey(freq)) {
            Node newHead=new Node(-1, -1);
            Node newTail=new Node(-1, -1);
            newHead.next=newTail;
            newTail.prev=newHead;
            freqToHead.put(freq, newHead);
            freqToTail.put(freq, newTail);
        }
    }
    void insertAtFirst(Node head, Node node) {
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
    Node deleteAtTail(Node head, Node tail) {
        if(head.next==tail) {
            return null;
        }
        Node lruNode=tail.prev;
        deleteNode(lruNode);
        return lruNode;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
