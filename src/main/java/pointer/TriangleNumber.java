package pointer;

import java.util.Arrays;

// todo 三指针，从后往前遍历
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3) return 0;

        int n = nums.length;
        int res = 0;
        for(int i = n-1; i>=2; i--){
            int l = 0, r = i - 1;
            while (l < r){
                if(nums[l] + nums[r] > nums[i]){
                    res += r - l;
                    --r;
                }else ++l;
            }

        }

        return res;
    }

}
