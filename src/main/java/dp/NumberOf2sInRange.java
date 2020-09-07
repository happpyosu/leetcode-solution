package dp;


// 面试题 17.06
public class NumberOf2sInRange {

    public static void main(String[] args) {
        NumberOf2sInRange n = new NumberOf2sInRange();
        int i = n.numberOf2sInRange(251);
        System.out.println(i);
    }


    // 设置
    // 情况1：nums[i] == 2
    // 30 -> 230  dp[i] = f(0~99) + f(100 ~ 199) + f(200 ~ 230) = 2 * f(0 ~ 99) + dp[i-1] + 30 + 1;

    // 情况2：nums[i] == 1
    // 30 -> 130  dp[i] = f(0 ~ 99) + f(100 ~ 130) = f(0 ~ 99) + dp[i-1];

    // 情况3：nums[i] == 0
    // 30 -> 030 dp[i] = dp[i-1]

    // 情况4：nums[i] > 2
    // 30 -> 530 dp[i] = f(0 ~ 99) + f(100 ~ 199) + f(200 ~ 299) + f(300 ~ 399) + f(400 ~ 499) + f(500 ~ 530)
    //  = 5 * f(0 ~ 99) +  100 + dp[i-1]
    public int numberOf2sInRange(int n) {
        String s = String.valueOf(n);
        int[] dp1 = new int[s.length()];
        int[] dp2 = new int[s.length()];

        dp1[0] = s.charAt(0) - '0' >= 2 ? 1 : 0;
        dp2[0] = 1;

        for(int j=1; j < s.length(); j++){
            int i = s.length() - 1 - j;
            int x = s.charAt(i) - '0';
            dp1[j] += x * dp2[j-1] + dp1[j-1];

            if(x == 2) dp1[j] += Integer.parseInt(s.substring(i+1)) + 1;
            else if(x > 2) dp1[j] += Math.pow(10, s.length() - i - 1);

            dp2[j] = (int) (10 * dp2[j-1] + Math.pow(10, s.length() - i - 1));
        }
        return dp1[s.length() - 1];
    }


}
