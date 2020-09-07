package dp;

import java.util.Arrays;
import java.util.stream.DoubleStream;

//leetcode 837
public class New21Game {

    public static void main(String[] args) {
//        int W = 10;
//        double d = ((1/(double)W) * 5);
//        System.out.println(d);
        New21Game n = new New21Game();
        double v = n.new21Game(6, 1, 10);
        System.out.println(v);
    }


    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K - 1 + W + 1];

        for(int i=K; i<dp.length; i++){
            if(i <= N) dp[i] = 1;
            else dp[i]= 0;
        }

        double sum = Arrays.stream(dp, K, dp.length).sum();

        for(int i=K-1; i>=0; i--){
            dp[i] = sum * (1.0 /  W);
            sum -= dp[i + W]; sum += dp[i];
        }

        return dp[0];
    }

}
