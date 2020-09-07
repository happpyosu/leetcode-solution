package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode 90
// 思考：题目子集二中并没有限制元素的重复性，题目子集一种元素是不重复的
// 对于子集I : {1, 2, 3}
// 可以先排序在每次递归种都把集合中的结果放进返回容器
// [1], [1, 2] [1, 3] [2] [2, 3] [3]

public class SubsetII {

    public static void main(String[] args) {
        SubsetII s = new SubsetII();
        int[] test = {1, 2, 2};
        List<List<Integer>> lists = s.subsetsWithDup(test);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        retList.add(new ArrayList<>());
        return retList;
    }

    private List<List<Integer>> retList = new ArrayList<>();

    private void dfs(int[] nums, int start, List<Integer> list){
        if(start >= nums.length) return;

        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            retList.add(new ArrayList<>(list));
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


}
