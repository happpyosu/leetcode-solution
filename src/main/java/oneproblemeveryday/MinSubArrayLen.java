package oneproblemeveryday;

public class MinSubArrayLen {

    public static void main(String[] args) {
        MinSubArrayLen m = new MinSubArrayLen();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int len = m.minSubArrayLen(7, nums);
        System.out.println(len);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length];
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(i == 0) sum[i] = nums[0];
            else sum[i] = sum[i-1] + nums[i];

            if(sum[i] == s) minLen = Math.min(minLen, i+1);
            else if(sum[i] > s){
                int diff = sum[i] - s;
                int result = binarySearch(sum, 0, i, diff);
                if(result >= 0) minLen = Math.min(minLen, i-result);
                else minLen = Math.min(minLen, i+1);

            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public int binarySearch(int[] arr, int start, int end, int target){
        int l = start; int r = end;

        while (l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) l = mid + 1;
            else if(arr[mid] > target) r = mid - 1;
        }
        if(r >= 0 && arr[r] <= target) return r;
        else return -1;
    }

}
