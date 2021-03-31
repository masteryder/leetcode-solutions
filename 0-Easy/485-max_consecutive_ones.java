class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
      int cur_consec_ones = 0;
      int max_consec_ones = 0;
      for(int i = 0; i< nums.length; i++)
      {
          if(nums[i] == 1)
          {
              cur_consec_ones +=1;
              if(cur_consec_ones > max_consec_ones)
              {
                  max_consec_ones = cur_consec_ones;
              }
          }
          else{
              cur_consec_ones = 0;
          }
      }
      return max_consec_ones;
  }
}