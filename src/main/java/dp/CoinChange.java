package dp;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {1, 2, 5};
        int i = c.revision1(coins, 11);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount){
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 0;
        for(int j = 1; j<=amount; j++) dp[0][j] = -1;

        for(int i=1; i<=coins.length; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0; k <= amount / coins[i-1]; k++){
                    if(j - k*coins[i-1] >= 0){
                        int pick = dp[i-1][j - k*coins[i-1]];
                        if(pick != -1){
                            dp[i][j] = Math.min(dp[i][j], pick + k);
                        }
                    }
                }
            }
        }
        return dp[coins.length][amount];
    }

    public int revision1(int[] coins, int amount){

        // dp[i][j]的含义是：截止到第i个物品，拿到j块钱所需要的最小硬币

        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for(int i=1; i<=amount; i++) dp[0][i] = -1;

        for(int i=1; i <=coins.length; i++){
            for(int j=1; j<=amount; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0; k <= amount / coins[i-1]; k++){  // 完全背包的这一步可以理解成第i个商品的重量是有一定范围的，
                                                              // 其范围为 0 ~ 下取整{背包容量 / 商品重量}
                    if(j - k*coins[i-1] >= 0){
                        int pick = dp[i-1][j - k*coins[i-1]];
                        if(pick != -1){
                            dp[i][j] = Math.min(pick + k, dp[i][j]);
                        }
                    }
                }
                if(dp[i][j] == Integer.MAX_VALUE) dp[i][j] = -1;
            }
        }

        return dp[coins.length][amount];
    }




}
