import java.util.ArrayList;
import java.util.Arrays;

public class DiffPossible {
	public static int diffPossible(ArrayList<Integer> a, int b) {
		for(int i=0; i<a.size()-1; i++)
			for(int j=i+1; j<a.size(); j++)
				if(Math.abs(a.get(i) - a.get(j)) == b)
					return 1;
		return 0;
	}

	public static void main(String[] args) {
		assert(1 == diffPossible(new ArrayList<>(Arrays.asList(2, 1, 5)), 4));
	}
}
