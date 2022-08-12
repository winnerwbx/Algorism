package HashTable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * Medium
 * <p>
 * 2928
 * <p>
 * 103
 * <p>
 * Favorite
 * <p>
 * Share
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2);
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

class LRUCache146 {
    private LinkedHashMap<Integer, Integer> map;
    private int size;

    public LRUCache146(int capacity) {
        size = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > size;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    class LRUCache {
        private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            makeRecent(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.put(key, value);
                makeRecent(key);
                return;
            }
            if (map.size() == capacity) {
                int a = map.keySet().iterator().next();
                map.remove(a);
            }
            map.put(key, value);
        }

        private void makeRecent(int key) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */