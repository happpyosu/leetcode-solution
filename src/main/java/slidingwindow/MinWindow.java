package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

// todo
// 76. 最小覆盖子串
// 维护一个滑动窗口
public class MinWindow {

    public static void main(String[] args) {
        MinWindow m = new MinWindow();
        String s = "ADOBECODEBANC";
        String t = "ABCQ";
        String window = m.minWindow(s, t);
        System.out.println(window);
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i=0; i<t.length(); i++) {
            set.add(t.charAt(i));
        }
        int i = 0; int j = -1; boolean forward = true;
        String retStr = null;
        while (j < s.length()){
            if (forward){
                j++;
                if(j < s.length() && set.contains(s.charAt(j))){
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                }
            }
            else{
                char cur = s.charAt(i);
                if(set.contains(cur)){
                    map.put(cur, map.getOrDefault(cur, 0) - 1);
                    if(map.get(cur) <= 0){
                        map.remove(cur);
                    }
                }
                i++;
            }

            if(map.keySet().equals(set)) {
                forward = false;
                if(retStr == null || j - i + 1 < retStr.length()) retStr = s.substring(i, j+1);
            }
            else forward = true;
        }
        return retStr == null ? "" : retStr;

    }

}
