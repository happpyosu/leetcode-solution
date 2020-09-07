package oneproblemeveryday;

import java.util.Scanner;

public class BallPath {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int n = scanner.nextInt();
            int[][] matrix = new int[n][2*n - 1];
            int middle = n - 1;
            for(int i=0; i<n; i++) {
                for(int j=middle-i; j<middle+i+1; j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println(getMaxPath(matrix, n));

        }
    }

    public static int getMaxPath(int[][] matrix, int n){
        int[][] dp = new int[n][2*n - 1];
        int mid = n - 1;

        for(int i=0; i<n; i++){
            for(int j=mid-i; j<mid+i+1; j++){
                int a = j+1 >= 2*n -1 ? 0 : dp[i-1][j+1];
                int b = j-1 < 0 ? 0 : dp[i-1][j-1];
                int c = dp[i-1][j];
                dp[i][j] = Math.max(a, Math.max(b, c)) + matrix[i][j];
            }
        }

        int max = -1;
        for(int j=0; j<2*n -1; j++){
            max = Math.max(max, dp[n-1][j]);
        }

        return max;
    }
}
