package Nc250.SlidingWindow;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{10, 1, 5, 6, 7, 1}));
        System.out.println(maxProfit(new int[]{10, 8, 7, 5, 2}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int currentDiff = prices[j] - prices[i];
                maxProfit = Math.max(currentDiff, maxProfit);
            }
        }

        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0, right = left + 1;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
