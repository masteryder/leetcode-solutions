class Solution {
    public void rotate(int[] nums, int k) {
        int first = 0;
        int km = k % nums.length;
        km = km == 0 ? k : km;
        System.out.print(km);

        for(int i = 0; i < km; i++){
            for(int j = nums.length -1; j >= 0; j--){
                if(j == nums.length -1) first = nums[j];
                else{
                    nums[j+1] = nums[j];
                }
            }
            nums[0] = first;
        }
    }
}