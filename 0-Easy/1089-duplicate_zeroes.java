class Solution {
  public void duplicateZeros(int[] arr) {
      // We can start for at index length -2 because if the last element is equal to 0 nothing changes in the array
      for(int i = arr.length -2; i >= 0; i--)
      {
          if( arr[i] == 0 ){
              for(int j = arr.length -1; j > i; j--){
                  arr[j] = arr[j - 1];
              }
          }
      }
  }
}