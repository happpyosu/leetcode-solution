package monostack;

import greedy.LargestSumAfterKNegations;

import java.util.Stack;

// todo
// leetcode 84
// 柱状图的最大面积
public class LargestRectangleArea {

    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        int[] a = {2, 1, 2};
        System.out.println(l.largestRectangleArea(a));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] h = new int[heights.length + 2];
        System.arraycopy(heights, 0, h, 1, heights.length);

        int maxBar = 0;

        for(int i=0; i<h.length; i++){
            while (!stack.isEmpty() && h[stack.peek()] > h[i]){
                int pop = stack.pop();
                maxBar = Math.max(maxBar, (i - stack.peek() - 1) * h[pop]);
            }

            stack.push(i);
        }

        return maxBar;
    }

}
