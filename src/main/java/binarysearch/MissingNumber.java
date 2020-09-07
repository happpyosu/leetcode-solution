package binarysearch;

public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,9};
        int i = missingNumber(a);
        System.out.println(i);
    }

    public static int missingNumber(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        while (i <= j){
            int mid = (i + j) / 2;

            if(nums[mid] == mid){
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }

        return i;

    }
}
