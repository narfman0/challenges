import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Wave {
	public static void main(String[] args) {
		ArrayList<Integer> result = null;
		
		result = wave(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
		assert(4 == result.size());
		assert(2 == result.get(0));
		assert(1 == result.get(1));
		assert(4 == result.get(2));
		assert(3 == result.get(3));
		
		result = wave(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
		assert(5 == result.size());
		assert(2 == result.get(0));
		assert(1 == result.get(1));
		assert(4 == result.get(2));
		assert(3 == result.get(3));
		assert(5 == result.get(4));
	}

    public static  ArrayList<Integer> wave(ArrayList<Integer> a) {
    	ArrayList<Integer> aSorted = new ArrayList<>(a);
	    Collections.sort(aSorted);
	    for(int i=0; i<a.size()-1; i+=2){
	        int temp = aSorted.get(i);
	        aSorted.set(i, aSorted.get(i+1));
	        aSorted.set(i+1, temp);
	    }
	    return aSorted;
    }
}
