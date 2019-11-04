package leetcode.easy;

public class Problem122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            int x = prices[i] - prices[i - 1];
            if (x > 0) {
                maxCur += x;
                if (i == prices.length - 1) {
                    maxSoFar += maxCur;
                }
            } else {
                maxSoFar += maxCur;
                maxCur = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Problem122 main = new Problem122();
        int[] prices;
        prices = null;
        System.out.println(main.maxProfit(prices));
        prices = new int[]{1};
        System.out.println(main.maxProfit(prices));
        prices = new int[]{1, 2, 3};
        System.out.println(main.maxProfit(prices));
        prices = new int[]{1, 2, 3, 2, 7};
        System.out.println(main.maxProfit(prices));
        prices = new int[]{1, 2, 3, 2, 1, 3};
        System.out.println(main.maxProfit(prices));
    }
}
