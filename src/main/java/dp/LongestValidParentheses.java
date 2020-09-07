package dp;

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        String s = "((())))";
        int validParentheses = l.longestValidParentheses(s);
        System.out.println(validParentheses);
    }


    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];

        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '(') dp[i] = dp[i-1];
            else if(c == ')'){
                if(s.charAt(i - 1) == '(') dp[i] = dp[i-1] + 2;
                else if(s.charAt(i-1) == ')' && i - dp[i-1] -1 >= 0 && s.charAt(i - dp[i-1] -1) == '(')
                    dp[i] = dp[i-1] + 2;
                else dp[i] = dp[i-1];
            }

        }
        return dp[dp.length - 1];
    }


}
