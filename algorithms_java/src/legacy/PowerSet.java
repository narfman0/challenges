/**
  *  Create a power set
  *  @return all subsets of a set
  */
public static List<T> createSubsets(Set<T> original){
	LinkedList<T> subsets = new LinkedList<>();
	int length = Math.pow(2, original.size());
	for(int i=1; i<length; i++){
		HashSet<T> permutation = new HashSet<>();
		for(int j=0; j<original.size(); j++)
			if((i >> j) & 0x1 == 1)
				permutation.add(original.get(j));
		subsets.add(permutation);
	}
	return subsets;
}