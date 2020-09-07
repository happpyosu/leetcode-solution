package dp;

import java.util.Arrays;

public class RobI {

    public static void main(String[] args) {
        RobI r = new RobI();
        int[] arr = {1,2,3,1};
        int[] arr1 = {2,7,9,3,1};
        int maxVal = r.rob(arr1);
        System.out.println(maxVal);
    }

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0]; dp[1] = nums[1];
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i],  dp[i-1]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

}
