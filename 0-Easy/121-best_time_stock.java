class Solution {

    // Bad solution O(n^2)
    public int maxProfit2(int[] prices) {
        int res = 0;
        for(int i = 0; i < prices.length-1; i++){
            for(int j = i; j < prices.length; j++){
                int curProfit = prices[j] - prices[i];
                if(curProfit > res) res = curProfit;
            }
        }
        return res;
    }

    public int maxProfit(int[] prices){
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i];
            if(prices[i] - minPrice > res) res = prices[i] - minPrice;
        }

        return res;
    }
}