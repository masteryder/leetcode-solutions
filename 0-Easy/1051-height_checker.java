class Solution {
    public int heightChecker(int[] heights) {
        int result = 0;
        int[] heightsSorted = new int[heights.length];

        for(int i=0;i<heights.length;i++){
            heightsSorted[i] = heights[i];
        }
        Arrays.sort(heightsSorted);
        for(int i=0;i<heights.length;i++){
            if(heights[i] != heightsSorted[i]) result++;
        }
        return result;
    }
}