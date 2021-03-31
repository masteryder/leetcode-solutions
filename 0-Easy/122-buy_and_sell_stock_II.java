class Solution {
    public int maxProfit(int[] prices) {

        boolean wasGoingUp = false;
        boolean isGoingUp = false;

        int curProfit = 0;
        int lastBoughtIndex = -1;

        for(int i = 0; i < prices.length; i++){

            if(i < prices.length - 1)
            {
                if(prices[i+1]>prices[i] || prices[i+1]==prices[i]) isGoingUp = true;

                if(prices[i+1]<prices[i]) isGoingUp = false;

                // sell
                if(wasGoingUp && !isGoingUp) curProfit += prices[i] - prices[lastBoughtIndex];
                // buy
                if(!wasGoingUp && isGoingUp) lastBoughtIndex = i;
            }
            else{
                if(wasGoingUp && isGoingUp) curProfit += prices[i] - prices[lastBoughtIndex];
            }

            wasGoingUp = isGoingUp;
        }
        return curProfit;
    }
}