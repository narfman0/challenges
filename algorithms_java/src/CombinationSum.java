import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        addCombinationSums(result, new LinkedList<>(), candidates, target, 0);
        return result;
    }
    
    public static void addCombinationSums(List<List<Integer>> result, List<Integer> current,
                                   int[] candidates, int target, int iStart){
        for(int i=iStart; i<candidates.length; i++){
            int difference = target - candidates[i];
            if(difference > 0){
                List<Integer> icurrent = new LinkedList<>(current);
                icurrent.add(candidates[i]);
                addCombinationSums(result, icurrent, candidates, difference, i);
            }else if(difference == 0) {
                List<Integer> icurrent = new LinkedList<>(current);
                icurrent.add(candidates[i]);
                result.add(icurrent);
            }
        }
    }
    
    public static void main(String[] vargs) {
    	List<List<Integer>> result = null;
    	//result = combinationSum(new int[] {2,3,6,7}, 7);
    	//assert(result.size() == 2);
    	result = combinationSum(new int[] {2,3,5}, 8);
    	assert(result.size() == 3);
    }
}
