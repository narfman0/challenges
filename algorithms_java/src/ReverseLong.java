public class ReverseLong {
	public static long reverse(long a) {
	    long result = 0;
	    for(int i=0; i<32; i++){
	    	long value = (a >> (31 - i)) & 0x1;
	        result |= (value << i);
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		assert(3221225472l == reverse(3));
	}
}
