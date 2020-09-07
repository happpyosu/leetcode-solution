package dp;

public class NumSquares {

    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        int squares = n.numSquares(13);
        System.out.println(squares);
    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i<dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];


    }

}
