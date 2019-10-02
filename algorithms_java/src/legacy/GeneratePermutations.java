import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GeneratePermutations {
	private static List<List<Integer>> generatePermutations(List<Integer> numbers){
		List<List<Integer>> result = new LinkedList<>();
		for(Integer number : numbers)
			result = generatePermutations(result, number);
		return result;
	}
	
	private static List<List<Integer>> generatePermutations(List<List<Integer>> permutations, int a){
		List<List<Integer>> result = new LinkedList<>();
		if(permutations.isEmpty()){
			result.add(new LinkedList<>());
			result.get(0).add(a);
			return result;
		}
		for(List<Integer> permutation : permutations)
			for(int i=0; i<permutation.size()+1; i++){
				List<Integer> newList = new ArrayList<>(permutation);
				newList.add(i, a);
				result.add(newList);
			}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		List<List<Integer>> permutations = generatePermutations(numbers); 
		assert(24 == permutations.size());
	}
}
