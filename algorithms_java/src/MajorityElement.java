import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
	public static void main(String[] args) {
		assert(6 == majorityElement(Arrays.asList(new Integer[]{1, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9})));
	}
	
	public static int majorityElement(final List<Integer> a) {
	    HashMap<Integer, Integer> counts = new HashMap<>();
	    int maxValue = -1,
	        maxCount = -1;
	    for(Integer aInt : a){
	        Integer count = counts.get(aInt);
	        if(count == null)
	            count = 1;
	        else
	        	count++;
	        if(count > a.size()/2)
	            return aInt;
	        if(count > maxCount){
	            maxValue = aInt;
	            maxCount = count;
	        }
	        counts.put(aInt, count);
	    }
	    return maxValue;
	}
}
