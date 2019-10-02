import java.util.List;
import java.util.ArrayList;

public class LineOfActiveCells{        
    public static List<Integer> cellCompete(int[] states, int days){
        List<Integer> result = new ArrayList<>();
        for(int state : states)
            result.add(state);
        //System.out.println("Days remaining " + days + " states: " + arrayToString(result));
        while(days > 0){
            evaluateCells(states, result);
            // for clarity/readability, placing this after the for loop, though
            // the postfix operater is evaluated after the while expression
            // is evaluated, so to be concise a programmer may put this in the while loop :).
            days--;
            //System.out.println("Days remaining " + days + " states: " + arrayToString(result));
            if(days > 0){
                // we must set up the loop for the next iteration
                for(int i=0; i<states.length; i++)
                    states[i] = result.get(i);
            }
        }
        return result;
    }
    
    public static void evaluateCells(int[] states, List<Integer> result){
        for(int i=0; i<states.length; i++){
            boolean leftActive = i == 0 ? false : states[i-1] == 1;
            boolean rightActive = i == states.length-1 ? false : states[i+1] == 1;
            int targetState = (leftActive && rightActive) || (!leftActive && !rightActive) ? 0 : 1;
            result.set(i, targetState);
        }
    }
    
    public static String arrayToString(List<Integer> result){
        StringBuilder builder = new StringBuilder("[");
        for(int i=0; i<result.size(); i++){
            builder.append(result.get(i));
            if(i+1 < result.size())
                builder.append(",");
        }
        return builder.append("]").toString();
    }

    
    public static void main(String[] args) {
    	int[] arr = {1, 1, 1, 0, 1, 1, 1, 1};
    	cellCompete(arr , 3);
    }
}