package array;

import commonskill.CommonSkills;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] arr = {0, 1, 0, 3, 12};
        m.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int i = nums.length - 1; int j = i;

        for(; i>=0; i--){
            if(nums[i] == 0){
                int k = i;
                while (k + 1 <= j){
                    CommonSkills.swap(nums, k, k+1);
                    k++;
                }
                j--;
            }
        }
    }





}
