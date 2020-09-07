package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstringWithNoReplica {

    public static void main(String[] args) {
        LengthOfLongestSubstringWithNoReplica l = new LengthOfLongestSubstringWithNoReplica();
        int length = l.lengthOfLongestSubstring("bbbbb");

        System.out.println(length);

    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int i = 0; int j = -1;
        while (j < s.length()){
            ++j;
            if(j < s.length()){
                char c = s.charAt(j);
                if(!set.contains(c)) set.add(c);
                else {
                    while (s.charAt(i) != c){
                        set.remove(s.charAt(i));
                        i++;
                    }
                    i++;
                }
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

}
