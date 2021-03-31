class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        boolean[] isPresent = new boolean[nums.length];
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            isPresent[nums[i]-1] = true;
        }
        for(int i = 0; i < isPresent.length; i++)
        {
            if(!isPresent[i]) result.add(i+1);
        }
        return result;
    }
}