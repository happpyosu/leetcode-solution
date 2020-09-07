package binarysearch;

// todo
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        int[] arr1 = {1, 3, 5, 7, 9, 11, 12, 13, 14};
        int[] arr2 = {2, 4, 6, 8, 10};

        int k = f.findKInTwoArray(arr1, 0, arr2, 0, 7);
        System.out.println(k);

    }


    private int findKInTwoArray(int[] nums1, int i, int[] nums2, int j, int k){
        if(i >= nums1.length) return nums2[j + k - 1];
        if(j >= nums2.length) return nums1[i + k - 1];

        if(k == 1) return Math.min(nums1[i], nums2[j]);

        int mid1 = (i + k/2 - 1) < nums1.length ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k/2 - 1) < nums2.length ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;

        if (mid1 < mid2) return findKInTwoArray(nums1, i + k/2, nums2, j, k - k/2);
        else return findKInTwoArray(nums1, i, nums2, j + k/2, k - k/2);
    }






}
