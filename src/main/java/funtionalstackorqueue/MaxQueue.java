package funtionalstackorqueue;

// 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和
// pop_front 的均摊时间复杂度都是O(1)。
//若队列为空，pop_front 和 max_value 需要返回 -1


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Deque<Integer> deque = new LinkedList<>();
    private Queue<Integer> queue = new LinkedList<>();

    public void push_back(int value){
        while (!deque.isEmpty() && deque.peekLast() < value){
            deque.removeLast();
        }
        queue.add(value);
        deque.addLast(value);
    }

    public int pop_front(){
        if(queue.size() > 0){
            int num = queue.poll();

            if(deque.peekFirst() == num){
                deque.removeFirst();
            }
            return num;
        }else {
            return -1;
        }
    }

    public int max(){
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }


}
