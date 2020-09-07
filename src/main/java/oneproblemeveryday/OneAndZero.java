package oneproblemeveryday;

public class OneAndZero {

    public static void main(String[] args) {
        OneAndZero o = new OneAndZero();
        String[] strs = {"10", "0001", "111001", "1", "0"};

        int maxUnit = o.findMaxForm(strs, 5, 3);

        System.out.println(maxUnit);

    }

    // leetcode 474 一和零
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


}
