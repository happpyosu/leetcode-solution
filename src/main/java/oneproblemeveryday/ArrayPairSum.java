package oneproblemeveryday;

import java.util.Arrays;

public class ArrayPairSum {

    public static void main(String[] args) {
        ArrayPairSum a = new ArrayPairSum();
        int[] arr = {1, 4, 3, 2};
        int sum = a.arrayPairSum(arr);
        System.out.println(sum);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i+=2){
            sum += nums[i];
        }

        return sum;

    }


}
