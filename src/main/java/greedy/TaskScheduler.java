package greedy;

import java.util.Arrays;

// todo
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks){
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int i = 25;

        while (i > 0 && map[i] == map[25]) i--;

        return Math.max(tasks.length, (map[25] - 1) * (n+1) + 25 - i);

    }



}
