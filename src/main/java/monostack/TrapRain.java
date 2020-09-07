package monostack;

import java.util.Stack;

public class TrapRain {

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int total = 0;
        //单调栈的标值写法，指针遍历
        //单调递减栈, 遇到一个非递减的值（高墙），就要计算一次雨水
        for(int i=0; i<height.length; i++){

            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int h = height[stack.peek()];
                stack.pop(); //相邻的两个墙不可能有雨水

                if(stack.isEmpty()){
                    break;
                }

                int distance = i - stack.peek() - 1;
                int minWall = Math.min(height[stack.peek()], height[i]);
                total += (minWall - h) * distance;


            }
            stack.push(i);
        }
        return total;
    }
}
