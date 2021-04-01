import java.util.*;
class Solution {
    // O (n^2)
    public List<List<Integer>> threeSum(int[] nums){
        // sort list
        Arrays.sort(nums);
        // define result array
        List<List<Integer>> res = new ArrayList();

        for(int i = 0; i < nums.length - 2; i++){

            int sum = 0 - nums[i];

            int p1 = i+1;
            int p2 = nums.length -1;

            while(p1 < p2){
                if(nums[p1] + nums[p2] == sum){
                    res.add(Arrays.asList(nums[i], nums[p1], nums[p2]));

                    p1++;
                    while(p1 < nums.length - 1 && nums[p1] == nums[p1-1])
                    {
                        p1++;
                    }

                    p2--;
                    while(p2 > i && nums[p2] == nums[p2+1]){
                        p2--;
                    }

                }
                else if(nums[p1] + nums[p2] > sum){
                    p2--;
                }
                else{
                    p1++;
                }
                while(i < nums.length - 2 && nums[i] == nums[i+1]) i++;
            }
        }
        return res;
    }

    // Bruteforce
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<String> triplets = new HashSet<String>();

        for(int i = 0 ; i < nums.length; i ++){
            for(int j = 0; j < nums.length; j++){
                for(int k = 0; k < nums.length; k++){
                    if(i!=j && i!=k && j!=k && nums[i]  + nums[j] + nums[k]  == 0 ){
                        ArrayList<Integer> ar = new ArrayList<Integer>();
                        ar.add(nums[i]);
                        ar.add(nums[j]);
                        ar.add(nums[k]);
                        Collections.sort(ar);
                        String key = ar.get(0)+","+ar.get(1)+","+ar.get(2);
                        if(!triplets.contains(key)){
                            triplets.add(key);
                            res.add(ar);
                        }
                    }
                }
            }
        }
        return res;
    }
}