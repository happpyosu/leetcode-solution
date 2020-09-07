package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class BagProblem {

    public static void main(String[] args) {
        BagProblem b = new BagProblem();
        int[][] grid = {
                {1, 5, 9},
                {2, 9, 7},
                {1, 1, 1},
                {3, 2, 4},
                {5, 6, 7}
        };

        int minPath = b.getMinPath(grid);
        System.out.println(minPath);

    }

    // leetcode 494
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).map(Math::abs).sum();
        int[][] dp = new int[nums.length][2*sum + 1];

        if(S > sum) return 0;

        if(nums[0] == 0) dp[0][sum]++;
        else {
            dp[0][sum + nums[0]]++;
            dp[0][sum - nums[0]]++;
        }

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<2*sum+1; j++){
                int part1 = j  - nums[i] < 0 ? 0 : dp[i-1][j - nums[0]];
                int part2 = j  + nums[i] > 2*sum ? 0 : dp[i-1][j + nums[0]];
                dp[i][j] = part1 + part2;
            }
        }
        return dp[nums.length-1][sum + S];
    }

    // 0-1背包问题
    // 已知每个物品的大小和价值，以及背包的最大容量，求最大价值
    public int oneZeroBagProblem(int[] weights, int[] values, int bagSize){
        int N = weights.length;
        int[] dp = new int[bagSize + 1];

        for(int i=0; i<N; i++){
            for(int j=bagSize; j >= 0; j--){
                if(j - weights[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    // 完全背包，每个物品可以拿无穷多次
    // leetcode 322 零钱兑换
    // todo
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


    // leetcode 474 二维费用的背包问题
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for(int i=1; i <= strs.length; i++){
            int[] zeroAndOne = countZeroAndOne(strs[i - 1]);
            int zeros = zeroAndOne[0]; int ones = zeroAndOne[1];
            for(int j=0; j <= m; j++){
                for(int k=0; k <= n; k++){
                    if(j - zeros >= 0 && k - ones >= 0)
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zeros][k-ones] + 1);
                    else dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }

        return dp[strs.length][m][n];
    }
    private int[] countZeroAndOne(String str){
        int zeros = 0;
        int ones = 0;

        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if(c == '1') ones++;
            else zeros++;
        }
        return new int[]{zeros, ones};
    }


    // 输入多个长度为3的序列，你需要从每个序列中选出一个数，使得相邻数字之间的差的绝对值的和最小，求这个最小值
    // 如输入[1, 3, 7], [2, 5, 4], [6, 7, 1]
    // 分别选择1， 2， 1 最小和为 |2 - 1| + |1 - 2| = 2
    public int getMinPath(int[][] grid){
        int[][] dp = new int[grid.length][3];
        for(int i=0; i<=2; i++) {
            dp[1][i] = Math.min(Math.abs(grid[1][i] - grid[0][0]),
                    Math.min(Math.abs(grid[1][i] - grid[0][1]), Math.abs(grid[1][i] - grid[0][2])));
        }

        for(int i=2; i < grid.length; i++){
            for(int j=0; j<=2; j++){
                dp[i][j] = Math.min(dp[i-1][0] + Math.abs(grid[i][j] - grid[i-1][0]), Math.min(
                        dp[i-1][1] + Math.abs(grid[i][j] - grid[i-1][1]),
                        dp[i-1][2] + Math.abs(grid[i][j] - grid[i-1][2])
                ));
            }
        }

        return Math.min(dp[grid.length-1][0], Math.min(dp[grid.length-1][1], dp[grid.length-1][2]));
    }





//    public static int dropMin(int[] arr){
//        int sum = Arrays.stream(arr).sum();
//        int half = sum / 2;
//        int len = arr.length;
//        int[][] dp = new int[len + 1][half + 1];
//
//        for(int i=1; i < len + 1; i++){
//            for(int j=1; j < half + 1; j++){
//                if(j - arr[i-1] >= 0) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i-1]] + arr[i-1]);
//                }else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        int maxSame = 0;
//        for(int j=half; j>=0; j--){
//            if(dp[len][j] == j && hasSum(arr, sum - 2 * j) && hasSum(arr, j)){
//                maxSame = j;
//                break;
//            }
//        }
//        return sum - 2 * maxSame;
//    }
//
//    public static boolean hasSum(int[] arr, int target){
//        boolean[] dp = new boolean[target + 1];
//        dp[0] = true;
//
//        for(int v : arr){
//            for(int j=target; j >= v; j--){
//                dp[j] = dp[j] || dp[j - v];
//            }
//        }
//        return dp[target];
//    }


}
