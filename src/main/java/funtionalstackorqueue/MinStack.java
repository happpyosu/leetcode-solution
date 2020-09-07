package funtionalstackorqueue;

//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
// 调用 min、push 及 pop 的时间复杂度都是 O(1)。

import java.util.Stack;

//思路： 维护两个栈
// 一个正常的栈，一个是最小栈，其中最小栈只有当入栈元素比栈顶元素还小是才能进行
public class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();
}
