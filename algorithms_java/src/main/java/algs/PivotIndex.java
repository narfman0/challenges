package algs;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int[] l = new int[nums.length], r = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            l[i] = nums[i] + (i == 0 ? 0 : l[i-1]);
        for(int i=nums.length-1; i>=0; i--)
            r[i] = nums[i] + (i == nums.length-1 ? 0 : r[i+1]);
        for(int i=0; i<nums.length; i++)
            if(l[i] == r[i])
                return i;
        return -1;
    }
}
