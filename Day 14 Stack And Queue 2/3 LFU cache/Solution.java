import java.util.* ;
class LFUCache {

    int capacity;
    int curSize;
    int minFrequency;
    Map<Integer, Node> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;

        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

   
    public int get(int key) {
        Node curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        updateNode(curNode);
        return curNode.val;
    }

    public void put(int key, int value) {
   
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            Node curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            curSize++;
            if (curSize > capacity) {
                
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            
            minFrequency = 1;
            Node newNode = new Node(key, value);

            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(Node curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);

        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        curNode.frequency++;

        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }


class Node {
    int key;
    int val;
    int frequency;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

 
class DoubleLinkedList {
    int listSize;
    Node head;
    Node tail;
    public DoubleLinkedList() {
        this.listSize = 0;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

       
    public void addNode(Node curNode) {
        Node nextNode = head.next;
        curNode.next = nextNode;
        curNode.prev = head;
        head.next = curNode;
        nextNode.prev = curNode;
        listSize++;
    }

    public void removeNode(Node curNode) {
        Node prevNode = curNode.prev;
        Node nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }

}
}
