package dp;

public class StockProblems {

    //假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少
    //股票的最大利润 0
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int minBuy = prices[0];
        int[] dp = new int[prices.length];
        int max = 0;
        for(int i=1; i<prices.length; i++){
            dp[i] = Math.max(prices[i] - minBuy, 0);
            minBuy = Math.min(minBuy, prices[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
