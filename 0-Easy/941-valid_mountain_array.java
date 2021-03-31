class Solution {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if(len < 3) return false;
        // if it doesn't start by going up
        if(arr[0] > arr[1]) return false;
        // if it doesn't end by going down
        if(arr[len-1] > arr[len-2]) return false; 
        
        short i = 0;
        //While going up
        while(i < len && arr[i] < arr[i+1]){
            i++;
        }
        // If we're at the end by only going up, then it's not a mountain
        if(i == len -1) return false;
                
        // While going down
        while(i < len-1 && arr[i] > arr[i+1]){
            i++;
        }
        // If we're at not at the end after going down then it's not a mountain
        if(i != len-1) return false;
        return true;
    }
}