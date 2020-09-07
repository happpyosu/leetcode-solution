package others;

import dp.LongestValidParentheses;

import java.util.Arrays;

// 求字符串中的最长回文子串
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        int i = l.manacher("abba");
        System.out.println(i);
    }

    private String preProcessing(String s){
        if(s.length() == 0) return "^$";
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (int i=0; i<s.length(); i++){
            sb.append('#').append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }

    public int manacher(String s){
        String T = preProcessing(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0; int R = 0;

        for(int i=1; i<n-1; i++){
            int i_mirror = 2 * C - 1;
            if(R > i) P[i] = Math.min(R-i, P[i_mirror]);
            else P[i] = 0;

            while (T.charAt(i - 1 - P[i]) == T.charAt(i + 1 + P[i])) P[i]++;

            if(i + P[i] > R){
                C = i;
                R = i + P[i];
            }
        }

        return Arrays.stream(P).max().getAsInt();
    }


}
