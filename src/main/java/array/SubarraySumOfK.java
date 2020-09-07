package array;

import java.util.HashMap;
import java.util.Map;

// todo
public class SubarraySumOfK {

    public static void main(String[] args) {
        SubarraySumOfK s = new SubarraySumOfK();
        int[] test = {1, 1, 1};
        int[] test2 = {3, 4, 7, 2, -3, 1, 4, 2};
        int c = s.subarraySum2(test2, 7);
        System.out.println(c);
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int num : nums) {
            int temp = sum + num;
            count += map.getOrDefault(temp - k, 0);
            sum += num;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0; int count = 0;
        map.put(0, 1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int c = map.getOrDefault(sum - k, 0);
            count += c;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


}
