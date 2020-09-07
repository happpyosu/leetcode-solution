package oneproblemeveryday;

import java.util.*;

//leetcode 140
public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII w = new WordBreakII();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        List<String> list = w.wordBreak(s, wordDict);

        System.out.println(list);

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        dfs(s, set, new StringBuilder());
        return list;
    }

    private List<String> list = new ArrayList<>();

    private void dfs(String remain, Set<String> set, StringBuilder sb){
        for (String s : set) {
            if(remain.startsWith(s)){
                sb.append(s).append(" ");
                String temp = remain.replaceFirst(s, "");
                if(temp.length() == 0) {
                    String string = sb.toString();
                    string = string.substring(0, string.length() - 1);
                    list.add(string);
                }
                else dfs(temp, set, sb);
                sb.delete(sb.length() - (s.length() + 1), sb.length());
            }
        }
    }



}
