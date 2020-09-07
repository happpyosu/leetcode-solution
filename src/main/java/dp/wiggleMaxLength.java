package dp;

// todo
// leetcode 376 摆动序列
public class wiggleMaxLength {

    public int wiggleMaxLength(int[] nums){

        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] down = new int[nums.length];
        int[] up = new int[nums.length];

        down[0] = up[0] = 1;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]) up[i] = Math.max(up[i], down[j] + 1);
                else if(nums[i] < nums[j]) down[i] = Math.max(down[i], up[j] + 1);
                else {
                    up[i] = Math.max(up[i], up[j]);
                    down[i] = Math.max(down[i], down[j]);
                }
            }
        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]);


    }

}
