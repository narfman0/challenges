package algs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInterleavingString {
    @Test
    public void testInterleavingStringFirst(){
        assertTrue(InterleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
