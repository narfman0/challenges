import java.util.ArrayList;
import java.util.Arrays;

public class CoverPoints {
	public static void main(String[] args) {
		assert(2 == coverPoints(
				new ArrayList<>(Arrays.asList(0, 1, 1)),
				new ArrayList<>(Arrays.asList(0, 1, 2))));
		assert(10 == coverPoints(
				new ArrayList<>(Arrays.asList(0, 5, 10)),
				new ArrayList<>(Arrays.asList(0, 0, 5))));
	}

    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int totalSteps = 0;
        for(int i = 1; i<X.size(); i++){
            int xDiff = Math.abs(X.get(i) - X.get(i-1));
            int yDiff = Math.abs(Y.get(i) - Y.get(i-1));
            totalSteps += Math.max(xDiff, yDiff);
        }
        return totalSteps;
    }
}
