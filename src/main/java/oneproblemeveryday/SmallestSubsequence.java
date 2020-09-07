package oneproblemeveryday;

import java.util.*;

public class SmallestSubsequence {

    public static void main(String[] args) {
        SmallestSubsequence s = new SmallestSubsequence();

        String testStr = "cdadabcc";
        String s1 = s.smallestSubsequence(testStr);

        System.out.println(s1);

    }


    public String smallestSubsequence(String text) {
        char[] charArray = text.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();


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

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }




}
