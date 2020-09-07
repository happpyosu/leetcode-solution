package dp;

import java.util.Arrays;


public class CanPartition {


    public static void main(String[] args) {
        CanPartition c = new CanPartition();
        int[] arr = {1, 2, 3, 5};
        boolean b = c.canPartition(arr);
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int half = sum / 2;
        int remain = sum % 2;
        if(remain != 0) return false;
        boolean[][] dp = new boolean[nums.length][half + 1];

       if(nums[0] <= half) dp[0][nums[0]] = true;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<=half; j++){
                if(nums[i] == j) dp[i][j] = true;
                else {
                    boolean b2 = (j - nums[i]) >= 0 && dp[i - 1][j - nums[i]];
                    dp[i][j] = dp[i-1][j] || b2;

                }
            }
        }

        return dp[nums.length-1][half];
    }


}
