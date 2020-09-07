package stringoperation;

import java.util.ArrayList;
import java.util.List;

// 有关回文字符串的题目的总结
// todo
public class PalindromeSummary {


    public static void main(String[] args) {
        PalindromeSummary p = new PalindromeSummary();
        List<List<String>> aab = p.partition("ababa");
        for (List<String> list : aab) {
            System.out.println(list);
        }

    }

    // -----------------------统计字符串中回文子串的个数-------------------------
    public int countSubstrings(String s) {
        int[] P = manacher(s);
        String processed = preProcessing(s);
        int count = 0;
        for(int i=1; i<processed.length()-1; i++){
            if(i % 2 == 1) count += P[i] / 2;  //奇数除以二
            else count += (P[i] - 1) / 2 + 1;  //偶数除以2 + 1
        }
        return count;
    }


    private String preProcessing(String s){
        if(s.length() == 0) return "^$";
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for(int i=0; i<s.length(); i++) sb.append('#').append(s.charAt(i));
        sb.append("#$");
        return sb.toString();
    }

    private int[] manacher(String s){
        String T = preProcessing(s);
        int[] P = new int[T.length()];
        int C = 0, R = 0;
        for(int i=1; i<P.length - 1; i++){
            int i_mirror = 2 * C - i;
            if(R > i){
                P[i] = Math.min(R -i, P[i_mirror]);
            }else P[i] = 0;

            while (T.charAt(i - 1 - P[i]) == T.charAt(i + 1 + P[i])) P[i]++;

            if(i + P[i] > R){
                C = i;
                R = i + P[i];
            }
        }
        return P;
    }

    //-------------------------131.分割回文串-----------------------------
    private boolean isPalindromeString(String s){
        if(s.length() == 0) return true;
        int i = 0; int j = s.length() - 1;
        while (i < j) {if(s.charAt(i++) != s.charAt(j--)) return false;}
        return true;
    }

    private final List<List<String>> retList = new ArrayList<>();
    // 131.分割回文串
    public List<List<String>> partition(String s){

        recur(s, new ArrayList<>());
        return retList;
    }

    private void recur(String s, List<String> list){
        if(s.length() == 0) {
            retList.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<s.length(); i++){
            String sub = s.substring(0, i+1);
            if(isPalindromeString(sub)) {
                list.add(sub);
                recur(s.substring(i+1), list);
                list.remove(list.size() - 1);
            }
        }

    }


}
