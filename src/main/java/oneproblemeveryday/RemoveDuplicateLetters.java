package oneproblemeveryday;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// leetcode 316
// hard 移除重复的字符
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();

        String test = "bbcaac";
        String s = r.removeDuplicateLetters(test);
        System.out.println(s);

    }


    public String removeDuplicateLetters(String s){

        HashMap<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();

        for(char c : charArray) map.put(c, map.getOrDefault(c, 0) + 1);

        for(char c : charArray){
            if(!set.contains(c)){
                while (!stack.isEmpty() && stack.peek() >= c && map.getOrDefault(stack.peek(), 0) > 0){
                    char pop = stack.pop();
                    set.remove(pop);
                }
                stack.push(c);
                set.add(c);
            }
                map.replace(c, map.getOrDefault(c, 0) - 1);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();

    }

}
