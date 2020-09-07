package oneproblemeveryday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysDivByK {

    public static void main(String[] args) {
//        SubarraysDivByK s = new SubarraysDivByK();
//        int[] A = {4,5,0,-2,-3,1};
//        int K = 5;
//
//        int div = s.subarraysDivByK(A, K);
//        System.out.println(div);

        int a = -3 % 5;
        System.out.println(a);

    }




    // O(N2)
    public int subarraysDivByK(int[] A, int K) {
        int positiveSum = 0;
        int negativeSum = 0;
        for (int i : A) {
            if(i > 0) positiveSum += i;
            else if(i < 0) negativeSum += i;
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0; i * K <= positiveSum; i++) set.add(i * K);
        for(int i=0; i * K >= negativeSum; i--) set.add(i * K);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0; int sum = 0;
        for (int value : A) {
            int temp = sum + value;
            for (int a : set) count += map.getOrDefault(temp - a, 0);
            sum += value;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    private static class Solution {
        public int subarraysDivByK(int[] A, int K) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0; int count = 0;
            for (int num : A) {
                sum += num;
                int remain = ((sum % K) + K) % K;
                count += map.getOrDefault(remain, 0);
                map.put(remain, map.getOrDefault(remain, 0) + 1);
            }

            return count;
        }


    }
}
