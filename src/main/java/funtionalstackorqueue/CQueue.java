package funtionalstackorqueue;

import java.util.Stack;

// 用两个栈实现队列
public class CQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        if(!s2.isEmpty()){
            return s2.pop();
        }else {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }

    }
}
