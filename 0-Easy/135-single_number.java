class Solution {
  
    // The obvious solution would be to create a hashmap with:
    // Key = number, value number of occurrences
    // Lets implement this
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> occurrences = new HashMap();
        
        for(int i = 0; i < nums.length; i++){
            if(occurrences.get(nums[i]) != null){
                occurrences.put(nums[i], 2);
            }
            else{
                occurrences.put(nums[i], 1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(occurrences.get(nums[i]) == 1 ) return nums[i];
        }
        return -1;
    }

    // The prompt asks : 
    // Q: Could you implement a solution with a linear runtime complexity and without using extra memory?
    // A: With a sorted Array we could do this without extra memory. The problems are: 1. it's destructive, 2. sorting is always worse than O(N)
    public int singleNumber2(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=2){
            if(i == nums.length - 1) return nums[i];
            else if(nums[i] != nums[i+1]){
                if( nums[i+1] != nums[i+2]){
                    return nums[i+1];
                }
                else{
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // We can also improve upon the first solution
    // By using a hashset, we can put elements we come across in the set if they are not present or remove them if they are
    // In the end, only one element will be left in the HashSet
    public int singleNumber3(int[] nums){
      HashSet<Integer> set = new HashSet();
      for(int i = 0; i < nums.length; i++){
         if(set.contains(nums[i])) set.remove(nums[i]);
         else set.add(nums[i]);
      }
      return set.iterator().next();
    }
    
    // The actual solution in O(n) time and O(1) space is using bitwise operation XOR    
    // I think this solution should also work if you want to find a single element that appears an odd number of times 
    // (and all the others appear an even amount of times)
    public int singleNumber(int[] nums){
        int res = 0; 
        for(int i : nums){
            res ^= i;
        }
        return res;
    }
}