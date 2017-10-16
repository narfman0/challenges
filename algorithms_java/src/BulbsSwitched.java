import java.util.ArrayList;
import java.util.Arrays;

public class BulbsSwitched {
	public static void main(String[] args) {
		assert(4 == bulbs(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1))));
		assert(2 == bulbs(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 0, 1))));
	}

    public static int bulbs(ArrayList<Integer> a) {
        int runner = 0;
        boolean flipped = false;
        for(int i = 0; i<a.size(); i++){
            if(a.get(i) == 0 && !flipped || a.get(i) == 1 && flipped){
                flipped = !flipped;
                runner++;
            }
        }
        return runner;
    }
}
