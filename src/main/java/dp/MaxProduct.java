package dp;

import java.util.Arrays;

public class MaxProduct {

    public static void main(String[] args) {
        int[] arr = {-2, 0, -1};
        MaxProduct m = new MaxProduct();
        int product = m.maxProduct(arr);
        System.out.println(product);
    }


    public int maxProduct(int[] nums) {
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];

        dp_max[0] = dp_min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp_max[i] = Math.max(nums[i], Math.max(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i]));
            dp_min[i] = Math.min(nums[i], Math.min(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i]));
        }

        return Arrays.stream(dp_max).max().getAsInt();
    }

}
