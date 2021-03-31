class Solution {
  public int removeDuplicates(int[] nums) {
      int removedEls = 0;
      for(int i = 0; i < nums.length - 1 - removedEls ; i++)
      {
          if(nums[i] == nums[i+1])
          {
              removedEls +=1;
              for(int j = i; j < nums.length -1; j++)
              {
                  nums[j] = nums[j+1];
              }
              i -=1;
          }
      }
      return nums.length - removedEls;
  }
}