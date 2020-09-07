package array;

import java.util.Arrays;

// todo
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();

        int[] arr = {1, 1, 5};

        n.nextPermutation2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;  int j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[j]){
            i--; j--;
        }

        int k;
        if(i < 0){
            i = 0;
            j = 1;
            k = nums.length - 1;
        }
        else {
            k = nums.length - 1;
            while (nums[k] <= nums[i]) k--;
        }

        swap(nums, i, k);
        Arrays.sort(nums, j, nums.length);
    }


    public void nextPermutation2(int[] nums){
        int i = nums.length - 2; int j = nums.length - 1;

        while (i >= 0 && nums[i] >= nums[j]){
            i--; j--;
        }

        int k = nums.length - 1;
        if(i < 0){
            i = 0; j = 1;
        }else {
            while (nums[k] <= nums[i]){
                k--;
            }
        }

        swap(nums, i, k);

        Arrays.sort(nums, j, nums.length);
    }



    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
