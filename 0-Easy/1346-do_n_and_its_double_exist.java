import java.util.Hashtable;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Hashtable<Integer, Integer> doubleVal = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> halfVal = new Hashtable<Integer, Integer>();
        for (int i = 0; i < arr.length; i++)
        {
            if( doubleVal.get(arr[i])!=null || halfVal.get(arr[i])!=null ) return true;
            doubleVal.put(arr[i]*2, arr[i]);
            if(arr[i] %2 == 0) halfVal.put(arr[i]/2, arr[i]);
        }
        return false;
    }
}