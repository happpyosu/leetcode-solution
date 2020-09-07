package dfs;

import java.util.HashMap;
import java.util.Map;

// todo
// leetcode 395
// 至少有K个重复字符的最长子串
public class LongestSubStringWithLeastKReplica {

    public static void main(String[] args) {

        LongestSubStringWithLeastKReplica l = new LongestSubStringWithLeastKReplica();
        String s = "ababbc";

        int count = l.count(s, 0, s.length() - 1, 2);
        System.out.println(count);


    }

    private int count(String s, int start, int end, int k){
        if(end - start + 1 < k) return 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=start; i <= end; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int p1 = start; int p2 = end;

        while (p2 - p1 + 1 > k && map.get(s.charAt(p1)) < k){
            p1++;
        }

        while (p2 - p1 + 1 > k && map.get(s.charAt(p2)) < k){
            p2--;
        }

        for(int i=p1; i<=p2; i++){
            if(map.get(s.charAt(i)) < k){
                return Math.max(count(s, p1, i-1, k), count(s, i+1, p2, k));
            }
        }

        return p2 - p1 + 1;
    }





}
