package array;

import java.util.Arrays;
import java.util.Random;

// # 189
// 输入: [1,2,3,4,5,6,7] 和 k = 3
// 输出: [5,6,7,1,2,3,4]
public class RotateArray {

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7};
        r.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        for(int i=0; i<k; i++){
            swap(nums, 0, nums.length - 1);
            int j = nums.length - 2;

            while (j >= 1){
                swap(nums, j, j+1);
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
