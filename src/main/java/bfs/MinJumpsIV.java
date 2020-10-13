package bfs;
import java.util.*;

// Leetcode 1345 跳跃游戏IV
public class MinJumpsIV {
    public int minJumps(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();//存储同值列表
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);//-1标记未跳过，
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new TreeSet<>());
            }
            map.get(arr[i]).add(i);
        }
        dp[0] = 0;
        Queue<Integer> queue = new LinkedList<>();//存储下一跳
        queue.offer(0);
        while (!queue.isEmpty()) {//队列中每次循环内的元素的次数应该是一致的
            int cur = queue.poll();
            Set<Integer> set = map.get(arr[cur]);
            for (int nxt: set) {//同值跳跃
                if (dp[nxt] == -1) {
                    dp[nxt] = dp[cur] + 1;
                    queue.offer(nxt);
                }
            }
            set.clear();//同值跳跃后需清除set，以免循环调用，所有同值以第一次跳计数
            if (cur - 1 >= 0 && dp[cur-1] == -1) {//向前跳
                dp[cur-1] = dp[cur] + 1;
                queue.offer(cur-1);//
            }
            if (cur + 1 < n && dp[cur+1] == -1) {//向后跳
                dp[cur+1] = dp[cur] + 1;
                queue.offer(cur+1);
            }
            if(dp[n-1]!=-1){return dp[n-1];}//有结果即可返回
        }
        return dp[n-1];
    }
}
