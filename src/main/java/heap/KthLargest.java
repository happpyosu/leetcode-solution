package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargest {

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest k = new KthLargest(3, arr);
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));

    }


    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private int size;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(priorityQueue.size() < size) priorityQueue.add(val);
        else {
            int minTop = priorityQueue.peek();
            if(val > minTop) {
                priorityQueue.poll();
                priorityQueue.add(val);
            }
        }

        return priorityQueue.peek();
    }


}
