package algs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMaxSubArray {
    @Test
    public void testMaxSubArray(){
        assertEquals(-1, MaxSubArray.maxSubArray(new int[]{-2,-1}));
        assertEquals(1, MaxSubArray.maxSubArray(new int[]{1}));
        assertEquals(1, MaxSubArray.maxSubArray(new int[]{-2,1}));
        assertEquals(6, MaxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(-1, MaxSubArray.maxSubArray(new int[]{-1}));
    }
}
