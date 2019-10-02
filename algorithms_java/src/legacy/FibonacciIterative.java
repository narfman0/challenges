public class FibonacciIterative {
	public static int fibonacci(int a) {
		if(a <= 2)
			return a;
		int l = 1, r = 2;
		for(int i=3; i<=a; i++){
			int newValue = l + r;
			l = r;
			r = newValue;
		}
		return r;
	}
	
	public static void main(String[] args) {
		assert(3 == fibonacci(3));
		assert(5 == fibonacci(4));
		assert(8 == fibonacci(5));
	}
}
