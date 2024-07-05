package algs;

import org.junit.jupiter.api.Test;

import static algs.PivotIndex.pivotIndex;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPivotIndex {
    @Test
    public void testPivotIndex(){
        int[] a = {1,7,3,6,5,6};
        assertEquals(3, pivotIndex(a));
    }
}
