package commonskill;

import java.util.Arrays;

public class PartitionArrayWithMinDeviation {

    // 分割数组为两部分，使得两部分的和的差尽可能小
    public static int partitionArrayWithMinDeviation(int[] arr){
        int sum = Arrays.stream(arr).sum();
        int half = sum / 2;
        int len = arr.length;

        int[][] dp = new int[len + 1][half + 1];

        for(int i=1; i < len + 1; i++){
            for(int j=1; j < half + 1; j++){
                if(j - arr[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i-1]] + arr[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[len][half];
    }

}
