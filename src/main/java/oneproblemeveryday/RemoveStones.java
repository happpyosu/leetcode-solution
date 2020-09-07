package oneproblemeveryday;

import java.util.HashSet;
import java.util.Set;

// leetcode 947 移除最多的同行或者同列石头
// 0 <= stones[i][j] < 10000
public class RemoveStones {

    private int[] fa = new int[20001];
    Set<Integer> res = new HashSet<>();


    public int removeStones(int[][] stones) {
        int len = stones.length;

        for (int[] stone : stones) {
            fa[stone[0]] = stone[0];
            fa[stone[1] + 10000] = stone[1] + 10000;
        }

        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10000);
        }

        for (int[] stone : stones) {
            res.add(findFather(stone[0]));
        }

        return len - res.size();

    }

    // 合并第a和第b个节点
    private void union(int a, int b){
        int first = findFather(a);
        int second = findFather(b);

        if(first != second){
            fa[second] = first;
        }

    }

    // 寻找a的父亲节点
    private int findFather(int a){
        while (fa[a] != a){
            a = fa[a];
        }
        return a;
    }




}
