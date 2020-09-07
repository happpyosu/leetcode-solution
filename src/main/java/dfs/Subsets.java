package dfs;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] test = {1, 2, 3, 4};
        List<List<Integer>> subsets = s.subsets(test);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        retList.add(new ArrayList<>());
        return retList;
    }

    private List<List<Integer>> retList = new ArrayList<>();

    private void dfs(int[] nums, int start, List<Integer> list){

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            retList.add(new ArrayList<>(list));
            dfs(nums, i+1, list);
            list.remove(list.size() - 1);
        }

    }

}
