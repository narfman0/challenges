package algs;

import org.junit.jupiter.api.Test;

import static algs.IntegerBreak.integerBreak;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIntegerBreak {
    @Test
    public void testIntegerBreak(){
        assertEquals(36, integerBreak(10));
    }
}
