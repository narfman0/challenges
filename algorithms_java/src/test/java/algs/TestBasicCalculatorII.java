package algs;

import org.junit.jupiter.api.Test;

import static algs.BasicCalculatorII.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBasicCalculatorII {
    @Test
    public void testBasicCalculator3_2_2(){
        assertEquals(7, calculate("3+2*2"));
    }

    @Test
    public void testBasicCalculator3_2(){
        assertEquals(1, calculate(" 3/2 "));
    }

    @Test
    public void testBasicCalculator3_5_2(){
        assertEquals(5, calculate(" 3+5 / 2 "));
    }

    @Test
    public void testBasicCalculator1_1_1(){
        assertEquals(3, calculate("1+1+1"));
    }
}
