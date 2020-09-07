package array;

import java.util.Arrays;

public class RelativeSortArray {

    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] array = r.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(array));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int j = -1;
        for (int val : arr2) {
            for (int k = j + 1; k < arr1.length; k++) {
                if (arr1[k] == val) swap(arr1, ++j, k);
            }
        }
        if(j+1 < arr1.length) Arrays.sort(arr1, j+1, arr1.length - 1);

        return arr1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
