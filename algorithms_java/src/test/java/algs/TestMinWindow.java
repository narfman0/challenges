package algs;

import org.junit.jupiter.api.Test;

import static algs.MinWindow.minWindow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMinWindow {
    @Test
    void testMinWindow(){
        String result = minWindow("ADOBECODEBANC", "ABC");
        assertEquals("BANC", result);
    }
}
