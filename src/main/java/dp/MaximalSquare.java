package dp;

import java.util.Arrays;

public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare m = new MaximalSquare();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int square = m.maximalSquare(matrix);
        System.out.println(square);
    }


    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length; int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int max = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){

                int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                int up = i - 1 >= 0 ? dp[i-1][j] : 0;
                int leftUp = (i - 1 >= 0 && j - 1 >= 0) ? dp[i-1][j-1] : 0;

                if(matrix[i][j] == '0') dp[i][j] = 0;
                else dp[i][j] = 1 + Math.min(left, Math.min(up, leftUp));

                max = Math.max(max, dp[i][j]);

            }
        }

        return max * max;



    }

}
