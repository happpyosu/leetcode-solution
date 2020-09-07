package array;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTriplet {

    // 判断数组nums中是否有严格递增的k元子序列
    // todo
    // leetcode 334
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1; i<nums.length; i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
                if(list.size() >= 3) return true;
                continue;
            }

            for(int j=0; j < list.size(); j++){
                if(list.get(j) >= nums[i]) {
                    list.remove(j);
                    list.add(j, nums[i]);
                    break;
                }
            }
        }

        return false;
    }
}
