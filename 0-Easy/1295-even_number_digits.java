class Solution {
    public int findNumbers(int[] nums) {
        int cpt_even_digits = 0;
        for(int i = 0; i < nums.length; i++)
        {
            String str_number = Integer.toString(nums[i]);
            if(str_number.length() % 2 == 0 )
            {
                cpt_even_digits++;
            }
        }
        return cpt_even_digits;
    }
}
