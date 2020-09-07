package oneproblemeveryday;

// leetcode 622
public class MyCircularQueue {


    public static void main(String[] args) {
        MyCircularQueue m = new MyCircularQueue(3);
        System.out.println(m.enQueue(1));
        System.out.println(m.enQueue(2));
        System.out.println(m.enQueue(3));
        System.out.println(m.enQueue(4));

        System.out.println(m.Rear());

        System.out.println(m.isFull());
        System.out.println(m.deQueue());
        System.out.println(m.enQueue(4));
        System.out.println(m.Rear());


    }


    private int front;
    private int rear;
    private final int[] arr;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.arr = new int[k + 1];
        this.front = 0;
        this.rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if((rear + 1) % arr.length == front) return false;
        arr[rear] = value;
        rear = (++rear) % arr.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (++front) % arr.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        int temp = rear - 1;
        if(temp < 0) temp += arr.length;
        return arr[temp];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear + 1) % arr.length == front;
    }
}
