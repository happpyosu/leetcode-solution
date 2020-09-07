package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {

    public static void main(String[] args) {
        ReconstructQueue r = new ReconstructQueue();
        int[][] q = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        int[][] reconstructQueue = r.reconstructQueue(q);
        for (int[] ints : reconstructQueue) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int[][] ret = new int[people.length][2];
        List<int[]> list = new LinkedList<>();
        for (int[] a : people) {
            if(list.isEmpty()) list.add(a);
            else list.add(a[1], a);
        }
        return list.toArray(ret);
    }
}
