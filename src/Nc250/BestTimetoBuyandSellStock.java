package Nc250;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {

        int profit = 0;

        for (int idx = 1; idx < prices.length; idx++) {
            if (prices[idx] > prices[idx - 1]) {
                profit = profit + (prices[idx] - prices[idx - 1]);
            }
        }

        return profit;
    }
}
