package dp;

public class RobII {

    public static void main(String[] args) {
        RobII r = new RobII();
        int[] test = {1, 2, 3, 1};

        System.out.println(r.rob(test));
    }


    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        System.arraycopy(nums, 0, nums1, 0, nums.length - 1);
        System.arraycopy(nums, 1, nums2, 0, nums.length - 1);

        int[] dp1 = new int[nums1.length];
        int[] dp2 = new int[nums2.length];

        dp1[0] = nums1[0]; dp2[0] = nums2[0];
        dp1[1] = Math.max(nums1[0], nums1[1]);
        dp2[1] = Math.max(nums2[0], nums2[1]);
        for(int i=2; i<nums.length - 1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums1[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums2[i]);
        }

        return Math.max(dp1[nums.length-2], dp2[nums.length-2]);
    }



}
