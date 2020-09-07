package commonskill;

public class Manacher {

    // 马拉车算法第一步，预处理字符串
    public static String preprocessing(String s){
        int n = s.length();
        if(n == 0) return "^$";
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for(int i=0; i<s.length(); i++) sb.append('#').append(s.charAt(i));
        sb.append("#$");
        return sb.toString();
    }

    // C 能够扩展到最大半径的那个字符
    // R 最大半径所在的最右边的字符
    public static String manacher(String s){
        String T = preprocessing(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;

        for(int i=1; i<n-1; i++){
            int i_mirror = 2 * C - i;
            if(R > i) P[i] = Math.min(R-i, P[i_mirror]);
            else P[i] = 0;
            while (T.charAt(i - 1 - P[i]) == T.charAt(i + 1 + P[i])) P[i]++;
            if(i + P[i] > R){
                C = i;
                R = i + P[i];
            }
        }

        int maxLen = 0; int centralIndex = 0;
        for(int i=1; i<n-1; i++){
            if(P[i] > maxLen){
                maxLen = P[i];
                centralIndex = i;
            }
        }

        int start = (centralIndex - maxLen) / 2;

        return s.substring(start, start + maxLen);

    }
}
