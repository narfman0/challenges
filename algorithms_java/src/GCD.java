public class GCD {
	public static void main(String[] args) {
		assert(2 == gcd(0, 2));
		assert(3 == gcd(3, 9));
		assert(16 == gcd(16, 256));
		assert(25 == gcd(50, 125));
	}
	
	public static int gcd(int a, int b) {
	    if(a == 0)
	        return b;
	    if(b == 0)
	        return a;
	    int gcdBuilder = 1, currentFactor = 2;
	    while(currentFactor <= a && currentFactor <= b){
	        if(a % currentFactor == 0 && b % currentFactor == 0) {
	            gcdBuilder *= currentFactor;
	            a /= currentFactor;
	            b /= currentFactor;
	        }
	        if(a % currentFactor != 0 || b % currentFactor != 0)
	            currentFactor += 1;
	    }
	    return gcdBuilder;
	}
}
