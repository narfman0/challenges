import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElement {
	public static int removeElement(ArrayList<Integer> a, int b) {
	    int found = 0;
	    for(int i=0; i<a.size(); i++)
	        if(a.get(i) == b)
	            found++;
	        else
	            a.set(i-found, a.get(i));
	    return a.size() - found;
	}
	
	public static void main(String[] args) {
		assert(3 == removeElement(new ArrayList<>(Arrays.asList(4, 1, 1, 2, 1, 3)), 1));
	}
}
