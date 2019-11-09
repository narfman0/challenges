package algs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static algs.KnightProbability.knightProbability;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKnightProbability {
    @Test
    public void testKnightProbability3_2_0_0() {
        assertEquals(knightProbability(3, 2, 0, 0), 0.06250);
    }
}
