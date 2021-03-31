class Solution {
    public int thirdMax(int[] nums) {

        boolean maxSet = false;
        boolean secondmaxSet = false;
        boolean thirdmaxSet = false;

        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        int thirdmax = Integer.MIN_VALUE;


        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max || !maxSet) {
                if(secondmaxSet) thirdmaxSet = true;
                if(maxSet) secondmaxSet = true;
                maxSet = true;

                thirdmax = secondmax;
                secondmax = max;
                max = nums[i];
            }
            else if((nums[i] > secondmax || !secondmaxSet) && nums[i] != max){
                if(secondmaxSet) thirdmaxSet = true;
                secondmaxSet = true;
                thirdmax = secondmax;
                secondmax = nums[i];
            }
            else if((nums[i] > thirdmax || !thirdmaxSet) && nums[i] != secondmax && nums[i] != max){
                thirdmaxSet = true;
                thirdmax = nums[i];
            }

        }
        if(thirdmaxSet) return thirdmax;
        else return max;
    }
}