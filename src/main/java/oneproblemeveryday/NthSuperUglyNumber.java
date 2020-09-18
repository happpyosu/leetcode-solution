package oneproblemeveryday;

import java.util.Arrays;

public class NthSuperUglyNumber {

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int uglyNumber = nthSuperUglyNumber(12, primes);

        System.out.println(uglyNumber);

    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;

        int[] count = new int[primes.length];
        Arrays.sort(primes);

        for(int i=1; i<n; i++){
            int nextVal = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j=0; j<count.length; j++){
                if(primes[j] * dp[count[j]] < nextVal){
                    nextVal = primes[j] * dp[count[j]];
                    minIdx = j;
                }
            }
            count[minIdx]++;
            dp[i] = nextVal;

            for(int j=0; j<count.length; j++){
                if(dp[count[j]] * primes[j] == nextVal) count[j]++;
            }

        }
        return dp[n-1];
    }

}
