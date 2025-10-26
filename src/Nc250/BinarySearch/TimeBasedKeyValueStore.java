package Nc250.BinarySearch;

import java.util.*;

public class TimeBasedKeyValueStore {

    /*
     * LinkedHashMap: Maintains the insertion order of elements. When iterating over a LinkedHashMap, elements are
     * returned in the order they were added.
     *
     * TreeMap: Stores elements in sorted order based on the natural ordering of its keys
     * (if they implement Comparable) or by a custom Comparator provided during its creation.
     * */
    //private HashMap<String, TreeMap<Integer, String>> keyValueStore;

    private Map<String, List<Pair<Integer, String>>> keyValueStore;

    public TimeBasedKeyValueStore() {
        this.keyValueStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        /*
        if (keyValueStore.containsKey(key)) {
            LinkedHashMap<Integer, String> valueStore = keyValueStore.get(key);
            valueStore.put(timestamp, value);
            keyValueStore.put(key, valueStore);
        } else {
            LinkedHashMap<Integer, String> valueStore = new LinkedHashMap<>();
            valueStore.put(timestamp, value);
            keyValueStore.put(key, valueStore);
        }*/


        keyValueStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!keyValueStore.containsKey(key)) {
            return "";
        }

        // TreeMap<Integer, String> timeStampsMap = keyValueStore.get(key);
        /*
         * floorEntry(K key): Returns a Map.Entry (key-value pair) associated with the greatest key less than or
         * equal to the given key. If no such key exists, it returns null.
         * */
        // Map.Entry<Integer, String> entry = timeStampsMap.floorEntry(timestamp);
        //return entry == null ? "" : entry.getValue();

        String result = "";
        List<Pair<Integer, String>> values = keyValueStore.get(key);
        int left = 0, right = values.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (values.get(mid).getKey() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else if (values.get(mid).getKey() > timestamp) {
                right = mid - 1;
            }

        }

        return result;

    }


    private static class Pair<K, V> {
        private K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

    }
}


class Solution {

    public static void main(String[] args) {
        TimeBasedKeyValueStore keyValueStore = new TimeBasedKeyValueStore();
        keyValueStore.set("alice", "happy", 1);
        System.out.println(keyValueStore.get("alice", 1));
        System.out.println(keyValueStore.get("alice", 2));
        keyValueStore.set("alice", "sad", 3);
        System.out.println(keyValueStore.get("alice", 3));
    }
}
