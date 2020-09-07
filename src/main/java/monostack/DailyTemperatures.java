package monostack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ret = d.dailyTemperatures(arr);

        System.out.println(Arrays.toString(ret));

    }


    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];
        for(int i=0; i<T.length; i++){

            if(stack.isEmpty() || T[stack.peek()] >= T[i]){
                stack.push(i);
            }else {

                while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                    int index = stack.pop();
                    ret[index] = i - index;
                }
                stack.push(i);
            }
        }

        return ret;


    }

}
