package binarysearch;

import java.util.Arrays;

public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate f = new FindDuplicate();
        int[] arr = {1, 2, 3, 4, 5, 5};
        int duplicate = f.findDuplicate(arr);
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;

        while (i <= j){
            int mid = (i + j) / 2;
            if(mid == nums[mid]) j = mid - 1;
            else if(mid == nums[mid] - 1){
                if(nums[mid + 1] > mid + 1) i = mid + 1;
                else return mid + 1;
            }
        }

        return i;
    }

}
