package commonskill;

import java.util.Stack;

// 计算逆波兰表达式的值
public class EvalRPN {

    public static void main(String[] args) {
        EvalRPN e = new EvalRPN();
        String[] tokens = {"4", "13", "5", "/", "+"};
        int rpn = e.evalRPN(tokens);
        System.out.println(rpn);
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                switch (token){
                    case "+": res = num2 + num1; break;
                    case "-": res = num1 - num2; break;
                    case "*": res = num1 * num2; break;
                    case "/": res = num1 / num2; break;
                }
                stack.push(res);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }

}
