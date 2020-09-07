package oneproblemeveryday;

import java.util.*;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        int[] candidates = {2, 5, 2, 1, 2};
        List<List<Integer>> lists = c.combinationSum2(candidates, 5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return new ArrayList<>(ret);
    }

    private Set<List<Integer>> ret = new HashSet<>();

    private void dfs(int[] candidates, int startIndex, int remain, List<Integer> list){
        if(startIndex >= candidates.length || remain <= 0) return;

        Set<Integer> set = new HashSet<>();

        for(int i=startIndex; i<candidates.length; i++) {
            int diff = remain - candidates[i];
            if (diff >= 0 && !set.contains(candidates[i])) {
                list.add(candidates[i]);
                set.add(candidates[i]);
                if (diff == 0) ret.add(new ArrayList<>(list));
                else {
                    dfs(candidates, i + 1, diff, list);
                }
                list.remove(list.size() - 1);
            }
        }
    }



}
