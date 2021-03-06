package oneproblemeveryday;

public class MaxDotProductOfTwoArr {

    public static void main(String[] args) {
        MaxDotProductOfTwoArr m = new MaxDotProductOfTwoArr();
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};

        int maxDotProduct = m.maxDotProduct(nums1, nums2);

        System.out.println(maxDotProduct);

    }


    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];


        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){

                dp[i][j] = nums1[i-1] * nums2[j-1];

                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                dp[i][j] = Math.max(dp[i-1][j-1] + nums1[i-1] * nums2[j-1], dp[i][j]);
                dp[i][j] = Math.max(dp[i][j-1], dp[i][j]);
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j]);
            }
        }
        return dp[len1][len2];
    }

}
