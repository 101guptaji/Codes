/*
 * Design a data structure that works like a LRU(Least Recently Used) Cache. The LRUCache class has two methods get() and put() which are defined as follows.

    LRUCache (Capacity c): Initialize LRU cache with positive size capacity c.
    get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
    put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the key-value pair with the lowest priority.
    Example:

    Input: [LRUCache cache = new LRUCache(2) , put(1 ,1) , put(2 ,2) , get(1) , put(3 ,3) , get(2) , put(4 ,4) , get(1) , get(3) , get(4)]
    Output: [1 ,-1, -1, 3, 4]
    Explanation: The values mentioned in the output are the values returned by get operations.

    Initialize LRUCache class with capacity = 2.
    cache.put(1, 1): (key, pair) = (1,1) inserted and has the highest priority.
    cache.put(2, 2): (key , pair) = (2,2) inserted and has the highest priority.
    cache.get(1): For key 1, value is 1, so 1 returned and (1,1) moved to the highest priority.
    cache.put(3, 3): Since cache is full, remove least recently used that is (2,2), (3,3) inserted with the highest priority.
    cache.get(2): returns -1 (key 2 not found)
    cache.put(4, 4): Since the cache is full, remove least recently used that is (1,1). (4,5) inserted with the highest priority.
    cache.get(1): return -1 (not found)
    cache.get(3): return 3 , (3,3) will moved to the highest priority.
    cache.get(4): return 4 , (4,4) moved to the highest priority.
 */
package javaDSA;

import java.util.*;

public class LRUCacheImplementation {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); //10
        cache.put(3, 30);
        System.out.println(cache.get(2)); //-1
        cache.put(4, 40);
        System.out.println(cache.get(1)); //-1
        System.out.println(cache.get(3)); //30
        System.out.println(cache.get(4)); //40
    }
}

/*
 * Method-1 Using Doubly Linked List and Hashing
    The idea is to keep inserting the key-value pair at the head of the doubly linked list. 
    When a node is accessed or added, it is moved to the head of the list (right after the dummy head node). 
    This marks it as the most recently used. 
    When the cache exceeds its capacity, the node at the tail (right before the dummy tail node) is removed as it represents the least recently used item.
 */
// class LRUNode {
//     int key;
//     int value;
//     LRUNode next;
//     LRUNode prev;

//     LRUNode(int key, int value) {
//         this.key = key;
//         this.value = value;
//         this.next = null;
//         this.prev = null;
//     }
// }

// class LRUCache{
//     int capacity;
//     Map<Integer, LRUNode> cache;
//     LRUNode head, tail;

//     LRUCache(int capacity){
//         this.capacity = capacity;
//         this.cache = new HashMap<>();
//         head = new LRUNode(-1, -1);
//         tail = new LRUNode(-1, -1);
//         head.next = tail;
//         tail.prev = head;
//     }

//     private void add(LRUNode curr){
//         LRUNode nextNode = head.next;
//         head.next = curr;
//         curr.prev = head;
//         curr.next = nextNode;
//         nextNode.prev = curr;
//     }

//     private void remove(LRUNode curr){
//         LRUNode prevNode = curr.prev;
//         LRUNode nextNode = curr.next;
//         prevNode.next = nextNode;
//         nextNode.prev = prevNode;
//     }

//     //TC: O(1)
//     int get(int key){
//         if(!cache.containsKey(key)){
//             return -1;
//         }

//         LRUNode curr = cache.get(key);
//         remove(curr);
//         add(curr);

//         return curr.value;
//     }

//     //TC: O(log n)
//     void put(int key, int value){
//         if(cache.containsKey(key)){
//             LRUNode oldNode = cache.get(key);
//             remove(oldNode);
//         }

        
//         LRUNode currNode = new LRUNode(key, value);
//         cache.put(key, currNode);
//         add(currNode);

//         if(cache.size()>capacity){
//             LRUNode lastNode = tail.prev;
//             remove(lastNode);;

//             cache.remove(lastNode.key);
//         }
//     }
// }

/*
 * Method-2 Using in-built function removeEldestEntry of LinkedHashMap in java
 * 
 */
class LRUCache {
    private static int size;
    private static LinkedHashMap<Integer, Integer> cache;
        
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        // code here
        size = cap;
        cache = new LinkedHashMap<>(cap, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > size;
            }
        };
    }

    // Function to return value corresponding to the key.
    // TC: O(1)
    public int get(int key) {
        // your code here
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return -1;
    }

    // Function for storing key-value pair.
    // TC: O(1)
    public void put(int key, int value) {
        // your code here
        cache.put(key, value);
    }
}