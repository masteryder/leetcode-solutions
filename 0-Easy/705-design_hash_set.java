class MyHashSet {

    private List<Integer>[] data;
    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new List[1000];
    }

    public void add(int key) {
        int hash = getHash(key);

        if(data[hash] == null ){

            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(key);

            data[hash] = al;
        }
        else{
            if(!contains(key)){
                data[hash].add(key);
            }
        }
    }

    public void remove(int key) {
        int hash = getHash(key);

        if(data[hash] == null ) return;
        else if(data[hash].size()==1){
            if(data[hash].get(0)==key) data[hash].clear();
            else return;
        }
        else {
            for(int i = 0; i < data[hash].size(); i++){
                if(data[hash].get(i)==key)
                {
                    data[hash].remove(i);
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = getHash(key);
        if(data[hash] == null) return false;
        else {
            for(int i = 0; i < data[hash].size(); i++){
                if(data[hash].get(i)==key)
                {
                    return true;
                }
            }
            return false;
        }
    }

    private int getHash(int key){
        String sKey = Integer.toString(key);
        int len = sKey.length();
        if(len > 3) len = 3;
        int hash = Integer.parseInt(sKey.substring(0, len));
        return hash;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */