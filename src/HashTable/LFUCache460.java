package HashTable;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache460 {
    class LFUCache {
        // key 到 val 的映射，我们后文称为 KV 表
        HashMap<Integer, Integer> keyToVal;
        // key 到 freq 的映射，我们后文称为 KF 表
        HashMap<Integer, Integer> keyToFreq;
        // freq 到 key 列表的映射，我们后文称为 FK 表
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        // 记录最小的频次
        int minFreq;
        // 记录 LFU 缓存的最大容量
        int cap;

        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            this.cap = capacity;
            this.minFreq = 0;
        }

        public int get(int key) {
            if (keyToVal.containsKey(key)) {
                incrFreq(key);
                return keyToVal.get(key);
            }
            return -1;
        }

        // 前提：key已经在各个map里了
        private void incrFreq(int key) {
            int currentFreq = keyToFreq.get(key);
            keyToFreq.put(key, currentFreq + 1);
            freqToKeys.get(currentFreq).remove(key);
            LinkedHashSet<Integer> newSet = freqToKeys.getOrDefault(currentFreq + 1, new LinkedHashSet<>());
            newSet.add(key);
            freqToKeys.put(currentFreq + 1, newSet);
            if (freqToKeys.get(currentFreq).isEmpty()) {
                freqToKeys.remove(currentFreq);
                if (currentFreq == minFreq) {
                    minFreq++;
                }
            }
        }

        public void put(int key, int value) {
            if (cap <= 0) {
                return;
            }
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                incrFreq(key);
                return;
            }
            if (cap == keyToVal.size()) {
                removeMinFreqKey();
            }
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            LinkedHashSet<Integer> set = freqToKeys.getOrDefault(1, new LinkedHashSet<>());
            set.add(key);
            freqToKeys.put(1, set);
            this.minFreq = 1;
        }

        private void removeMinFreqKey() {
            LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
            int toBeRemovedKey = keys.iterator().next();
            keys.remove(toBeRemovedKey);
            if (keys.isEmpty()) {
                freqToKeys.remove(minFreq);
                // IMPORTANT: 这里不需要更新minFreq，因为这个函数只在pub里调用，put会更新这个值
            } else {
                freqToKeys.put(minFreq, keys);
            }
            keyToVal.remove(toBeRemovedKey);
            keyToFreq.remove(toBeRemovedKey);
        }
    }

}
