import java.util.Arrays;
import java.util.List;

public class DoubleDuplicate {
	public static void main(String[] args) {
		assert(2 == duplicate(Arrays.asList(1, 1, 2, 3, 3)));
	}

	/**
	 * @param a list of integers composed of doubles of every integer except one
	 * @return the single integer that is not duplicated
	 */
	public static int duplicate(final List<Integer> a) {
	    int runner = 0;
	    for(Integer x : a)
	        runner ^= x;
	    return runner;
	}
}
