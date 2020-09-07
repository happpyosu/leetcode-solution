package dp;



public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int stairs = m.minCostClimbingStairs(cost);
        System.out.println(stairs);
    }


    public int minCostClimbingStairs(int[] cost) {
        if(cost == null) return 0;

        int[] dp = new int[cost.length + 1];
        dp[0] = 0; dp[1] = 0;

        for(int i=2; i<dp.length; i++){
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }

        return dp[dp.length - 1];
    }

}
