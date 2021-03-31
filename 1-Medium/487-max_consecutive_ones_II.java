class Solution {

    int curLeftChain = 0;
    int curRightChain = 0;
    boolean zeroInbetween = false;
    int max = 1;

    public int findMaxConsecutiveOnes(int[] nums) {


        int pointer = 0;
        if(nums.length == 1) return max;

        while(pointer < nums.length)
        {
            if(nums[pointer]==1) // if we have a 1
            {
                if(zeroInbetween){
                    curRightChain++;
                }
                else{
                    curLeftChain++;
                }
                if(pointer == nums.length - 1)
                {
                    checkIfMax();
                }
            }
            else // if we have a 0
            {
                if(zeroInbetween){
                    checkIfMax();
                    curLeftChain = curRightChain;
                    curRightChain = 0;
                }
                else{
                    zeroInbetween = true;
                }

                if(pointer == nums.length - 1)
                {
                    checkIfMax();
                }
                // if there's two consecutive 0's rather than 1
                if(pointer!= nums.length -1 && nums[pointer+1]==0)
                {
                    zeroInbetween = false;
                    curLeftChain = 0;
                    curRightChain = 0;
                }

            }
            pointer++;
        }
        return max;
    }

    public void checkIfMax(){
        int maxCandidate = 0;

        if(zeroInbetween) maxCandidate = curLeftChain+curRightChain+1;
        else maxCandidate = curLeftChain+curRightChain;

        if(maxCandidate > max)
        {
            max = maxCandidate;
        }
    }
}