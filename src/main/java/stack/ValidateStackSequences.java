package stack;

import java.util.Stack;

public class ValidateStackSequences {

    public static void main(String[] args) {
        ValidateStackSequences v = new ValidateStackSequences();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};

        boolean b = v.validateStackSequences(pushed, popped);
        System.out.println(b);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {


        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;

        while (true){
            if(!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }else if(pushIndex < pushed.length){
                stack.push(pushed[pushIndex++]);
            }else {
                break;
            }
        }

        return popIndex == popped.length;

    }

}
