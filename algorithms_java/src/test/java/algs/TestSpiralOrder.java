package algs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static algs.SpiralOrder.spiralOrder;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSpiralOrder {
    @Test
    public void testSpiralOrder(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Integer[] expected = {1,2,3,6,9,8,7,4,5};
        List<Integer> result = spiralOrder(matrix);
        Integer[] arr = new Integer[result.size()];
        result.toArray(arr);
        assertTrue(Arrays.deepEquals(expected, arr));
    }
}
