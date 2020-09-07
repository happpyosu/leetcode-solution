package dp;

public class MaxSubArray {

    public int maxSubArray(int[] nums){

        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        // dp的语义：以第i个元素结尾的最大子数组

        dp[0] = nums[0];
        int max = 0;
        for(int i=1; i<nums.length; i++){
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;


    }

}
