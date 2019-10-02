public class SumForTwo {
	/**
	 * Note: witnessed in the wild :)
	 */
	public static boolean sumForTwo(int[] array, int b){
		Arrays.sort(array);
		for(int i=0; i<array.length; i++){
			int value = Math.abs(array[i] - b);
			int left = 0, right = array.length - 1;
			while(left != right){
				int middle = (right - left) / 2;
				if(middle == value)
					return true;
				else if(array[middle] > value)
					left = middle + 1;
				else
					right = middle - 1;
			}
		}
		return false;
	}
}