package algs;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = nums[0], current = nums[0];
        for(int i=1; i<nums.length; i++){
            current = Math.max( nums[i], current+ nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}
