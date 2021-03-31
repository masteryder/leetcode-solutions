class Solution {
public void merge(int[] nums1, int m, int[] nums2, int n) {

    if( n == 0 ) return;

    int pointer1 = m-1;
    int pointer2 = n-1;
    boolean takeValueFrom2 = false;

    for(int i = nums1.length-1; i >= 0; i-- ){
        if(pointer1 < 0)
        {
            takeValueFrom2 = true;
        }
        else if(pointer2 < 0)
        {
            takeValueFrom2 = false;
        }
        else if(nums1[pointer1] >= nums2[pointer2])
        {
            takeValueFrom2 = false;
        }
        else if(nums2[pointer2] > nums1[pointer1])
        {
            takeValueFrom2 = true;
        }

        if(takeValueFrom2){
            nums1[i] = nums2[pointer2];
            pointer2--;
        }
        else{
            nums1[i] = nums1[pointer1];
            pointer1--;
        }
    }
}
}