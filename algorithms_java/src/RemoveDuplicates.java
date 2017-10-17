import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {
	public static int removeDuplicates(ArrayList<Integer> a) {
	    int resultSize = a.size();
	    for(int i=1; i<resultSize;){
	        if((int)a.get(i) == (int)a.get(i-1)){
	        	int skip = 1;
	            for(int j=i+1; j<resultSize-1; j++)
	            	if((int)a.get(j) == (int)a.get(j-1)){
	            		skip++;
	            		resultSize--;
	            	}else
	            		break;
	            for(int j=i+skip; j<a.size(); j++)
	                a.set(j-skip, a.get(j));
	            resultSize--;
	        }else
	            i++;
	    }
	    return resultSize;
	}
	
	public static void main(String[] args) {
		assert(5 == removeDuplicates(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 5))));
		assert(1 == removeDuplicates(new ArrayList<>(Arrays.asList(5000, 5000, 5000))));
		assert(4 == removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 2, 2, 3))));
		assert(4 == removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 ,1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3))));
	}
}
