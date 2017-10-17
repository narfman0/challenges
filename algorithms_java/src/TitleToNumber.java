public class TitleToNumber {
	/**
	 * @return number representing column, e.g. AA returns 27
	 */
	public static int titleToNumber(String a) {
	    int result = 0;
	    for(int i=0; i<a.length(); i++){
	        result *= 26;
	        result += convert(a.charAt(i));
	    }
	    return result;
	}
	
	/**
	 * Calculate a spreadsheet row for a character
	 * e.g. 'A' returns 1, since it is the first column
	 * @param a character to convert. Must be capitalized.
	 * @return spreadsheet-centered integer representing column
	 */
	private static int convert(char a){
	    return (int)a - 64;
	}
	
	public static void main(String[] args) {
		assert(1 == titleToNumber("A"));
		assert(3 == titleToNumber("C"));
		assert(27 == titleToNumber("AA"));
	}
}
