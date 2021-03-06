class Solution {
    public int[] replaceElements(int[] arr) {
        int biggestYet = arr[arr.length -1];
        arr[arr.length-1] = -1;
        
        for(int i = arr.length - 2; i >= 0; i--)
        {
            int oldVal = arr[i];
            arr[i] = biggestYet;
            if(oldVal > biggestYet){
                biggestYet = oldVal;
            }
        }
        return arr;
    }
}