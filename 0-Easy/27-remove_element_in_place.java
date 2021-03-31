 class Solution {
    public int removeElement(int[] nums, int val) {

        int removedEls = 0;
        for(int i = 0; i < nums.length - removedEls ; i++)
        {
            if(nums[i] == val)
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