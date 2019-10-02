public class NumSetBits {
	public static void main(String[] args) {
		assert(1 == numSetBits(2));
		assert(3 == numSetBits(7));
	}

	public static int numSetBits(long a) {
		int total = 0;
		for(int i=0; i<32; i++)
			if(((a >> i) & 0x1) > 0)
				total++;
		return total;
	}
}
