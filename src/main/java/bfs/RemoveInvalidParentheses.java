package bfs;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        String s = "(a)())()";
        List<String> list = r.removeInvalidParentheses(s);
        for (String str : list) {
            System.out.println(str);

        }
    }

    // 判断一个只带括号的字符串是不是有效的字符串
    public static boolean isValidParentheses(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            if(count < 0) return false;
        }

        return count == 0;
    }

    public List<String> removeInvalidParentheses(String s){

        Set<String> level = new HashSet<>();
        level.add(s);
        while (!level.isEmpty()){
            List<String> list = new ArrayList<>();
            for (String str : level) {
                if(isValidParentheses(str)) list.add(str);
            }
            if(!list.isEmpty()) return list;

            Set<String> next_level = new HashSet<>();
            for (String str : level) {
                for(int i=0; i<str.length(); i++){
                    if(str.charAt(i) == '(' || str.charAt(i) == ')'){
                        next_level.add(str.substring(0, i) + str.substring(i+1));
                    }
                }
            }
            level = next_level;
        }

        return new ArrayList<>();
    }








}
