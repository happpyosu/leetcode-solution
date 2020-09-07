package topkproblem;

import java.util.HashMap;
import java.util.PriorityQueue;

// todo
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        for (Integer key : hashMap.keySet()) {
            if(priorityQueue.size() < k) priorityQueue.add(key);
            else {
                if(hashMap.get(key) > priorityQueue.peek()){
                    priorityQueue.remove();
                    priorityQueue.add(key);
                }
            }
        }

        int[] ret = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty())
            ret[i++] = priorityQueue.remove();

        return ret;
    }

}
