public class TrailingZeroes {
	public static int trailingZeroes(String a) {
	    if(a < 5)
	        return 0;
	    return a/5 + trailingZeroes(a/5);
	}

	public static void main(String[] args) {
		assert(1 == trailingZeroes(5));
	}
}
