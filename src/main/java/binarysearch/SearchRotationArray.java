package binarysearch;

// todo
public class SearchRotationArray {

    public int search(int[] nums, int target) {
        int l = 0; int r = nums.length - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[0]){  //在左半部分
                if(target >= nums[0] && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }else {  // 在右半部分
                if(target > nums[mid] && target <= nums[nums.length - 1]){
                    l = mid + 1;
                }else r = mid - 1;
            }
        }

        return -1;
    }


    public int searchInRotation(int[] arr, int target){
        int l = 0; int r = arr.length - 1;

        while (l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] >= arr[0]){
                if(target >= arr[0] && target < arr[mid]) r = mid - 1;
                else l = mid + 1;
            }else {
                if(target <= arr[arr.length - 1] && target > arr[mid]) l = mid + 1;
                else  r = mid - 1;
            }
        }

        return -1;

    }


}
