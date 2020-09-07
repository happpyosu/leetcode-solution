package binarysearch;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        SearchRange s = new SearchRange();

        int[] arr = {5,7,7,8,8,10};

        System.out.println(Arrays.toString(s.searchRange(arr, 7)));

    }

    public int[] searchRange(int[] nums, int target) {
        int index = searchInRange(nums, target, 0, nums.length - 1);
        if(index == -1) return new int[]{-1, -1};

        int left = index; int right = index;

        while (true){
            int l = searchInRange(nums, target, 0, left - 1);
            if(l == -1) break;
            else left = l;
        }

        while (true){
            int r = searchInRange(nums, target, right+1, nums.length - 1);
            if(r == -1) break;
            else right = r;
        }

        return new int[]{left, right};


    }

    // 在范围中查找，如果没有找到就返回-1
    private int searchInRange(int[] nums, int target, int start, int end){

        if(start < 0 || end >= nums.length || start > end) return -1;

        while (start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] > target) end = mid - 1;
            else if(nums[mid] < target) start = mid + 1;
            else return mid;
        }

        return -1;
    }


}
