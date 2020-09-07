package others;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        int[] test = {1,2,3,4};
        int[] self = p.productExceptSelf(test);
        System.out.println(Arrays.toString(self));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;
        int l = 1; int r = 1;
        for(int i=1; i<nums.length; i++){
            l *= nums[i-1];
            r *= nums[nums.length - i];
            left[i] = l;
            right[nums.length - i - 1] = r;
        }

        int[] ret = new int[nums.length];

        for(int i=0; i<ret.length; i++){
            ret[i] = left[i] * right[i];
        }

        return ret;


    }

}
