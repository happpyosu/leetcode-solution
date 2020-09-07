package oneproblemeveryday;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class RemoveKDigitsGetMin {

    public static void main(String[] args) {
        RemoveKDigitsGetMin r = new RemoveKDigitsGetMin();
        String nums = "10200";
        String s = r.removeKdigits(nums, 1);
        System.out.println(s);

    }


    public String removeKdigits2(String num, int k){
        Stack<Character> stack = new Stack<>();
        char[] charArray = num.toCharArray();

        for(char c : charArray){
            while (k>0 && stack.peek() > c){
                --k;
                stack.pop();
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().substring(0, num.length() - k);

    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = num.toCharArray();

        int remain = num.length() - k;

        for(char c : charArray){
            while (k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

       String temp =  sb.reverse().toString().substring(0, remain).replaceFirst("^0*", "");

        return temp.length() == 0 ? "0" : temp;


    }



    }
