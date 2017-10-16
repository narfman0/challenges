public class LengthOfLastWord {
	public static void main(String[] args) {
		assert(1 == lengthOfLastWord("d"));
		assert(4 == lengthOfLastWord("word   "));
		assert(5 == lengthOfLastWord("hello world"));
		assert(5 == lengthOfLastWord("Hello World  "));
	}

	public static int lengthOfLastWord(final String a) {
	    int length = a.length(),
	        currentLength = 0;
        boolean started = false;
	    for(int i=length-1; i>=0; i--){
	        if(started && a.charAt(i) == ' ')
	            return currentLength;
	        if(a.charAt(i) != ' '){
	            started = true;
	            currentLength++;
	        }
	    }
        return currentLength;
	}
}
