package leetcode.easy;

public class Problem121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur += (prices[i] - prices[i - 1]);
            if (maxCur > maxSoFar) {
                maxSoFar = maxCur;
            } else if (maxCur < 0) {
                maxCur = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Problem121 main = new Problem121();
        int[] input;
        input = null;
        System.out.println(main.maxProfit(input));
        input = new int[]{1};
        System.out.println(main.maxProfit(input));
        input = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(main.maxProfit(input));
    }
}
