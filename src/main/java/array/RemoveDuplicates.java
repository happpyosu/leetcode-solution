package array;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] arr = {0,0,1,1,1,2,2,2,2,2,3,3,4,4,4,4,4};
        int duplicates = r.removeDuplicates(arr);
        System.out.println(duplicates);
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int i = 0;

        for(int j=1; j<nums.length; j++){
            if(nums[j] == nums[i]) continue;
            else swap(nums, ++i, j);
        }

        return i+1;

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
