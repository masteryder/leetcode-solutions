import java.util.HashMap; // import the HashMap class

class LRUCache {

    private HashMap<Integer, Integer> cacheValues;
    private int maxCapacity;
    private int usedCapacity = 0;
    private LinkedList<Integer> keyOrder = new LinkedList();

    public LRUCache(int capacity) {
        maxCapacity = capacity;
        cacheValues = new HashMap<Integer, Integer>();
    }

    public int get(int key) {
        if (cacheValues.containsKey(key)){
            int old_index = keyOrder.indexOf(key);
            if(old_index != 0){
                keyOrder.remove(old_index);
                keyOrder.addFirst(key);
            }
            return cacheValues.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {
        // if key exists already
        if(cacheValues.containsKey(key)){
            int old_index = keyOrder.indexOf(key);
            if(old_index != 0){
                keyOrder.remove(old_index);
                keyOrder.addFirst(key);
            }
            cacheValues.put(key, value);
        }
        else{
            if(usedCapacity == maxCapacity){
                int last_key = keyOrder.getLast();
                // Remove the key that is LRU
                cacheValues.remove(last_key);

                // Add new value to cache array
                cacheValues.put(key, value);

                // remove the last element
                keyOrder.remove(maxCapacity - 1);

                // add a new first element to the linked list
                keyOrder.addFirst(key);
            }
            else{
                cacheValues.put(key, value);
                keyOrder.addFirst(key);
                usedCapacity++;
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */