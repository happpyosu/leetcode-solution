package commonskill;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// 将中序表达式转换为后序表达式
public class ReversePolishNotation {

    public static void main(String[] args) {
        ReversePolishNotation r = new ReversePolishNotation();
        String test = "5 + 2 * (3 * (3 - 1 * 2 + 1))";
        String test2 = "(5 + 2) * 6";

        String s = r.convert(test2);
        System.out.println(s);
    }


    private static final HashMap<Character, Integer> priority = new HashMap<>();
    private static final Stack<Character> stack = new Stack<>();
    private static final Set<Character> validSet = new HashSet<>();

    public ReversePolishNotation(){
        priority.put('+', 0); priority.put('-', 0);
        priority.put('*', 1); priority.put('/', 1);
        priority.put('(', 2); priority.put(')', 2);

        validSet.add('+'); validSet.add('-');
        validSet.add('*'); validSet.add('/');
        validSet.add('('); validSet.add(')');

        for(int i=0; i<=9; i++) validSet.add((char) ('0' + i));

    }

    private String convert(String s){
        stack.clear();

        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();

        for(char c : charArray){
            if(c == ' ') continue;
            if(!validSet.contains(c)) throw new RuntimeException("invalid character: " + c);

            if(Character.isDigit(c)) sb.append(c);
            else if(c == '(') stack.push(c);
            else if(c == ')'){
                while (stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                if(stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                int top = priority.get(stack.peek()); int cur = priority.get(c);
                while (top >= cur && stack.peek() != '('){
                    sb.append(stack.pop());
                    top = priority.getOrDefault(stack.peek(), -1);
                }
                stack.push(c);
            }else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }





}
