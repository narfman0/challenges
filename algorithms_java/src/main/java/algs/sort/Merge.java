package algs.sort;

import java.util.Arrays;

public class Merge {
	public static int[] mergeSort(int[] array) {
		return mergeSort(array, 0, array.length-1);
	}
	
	public static int[] mergeSort(int[] array, int l, int r) {
		if(l == r)
			return array;
		if(r - l <= 1){
			if(array[l] > array[r]){
				// swap two elements
				array[l] ^= array[r];
				array[r] ^= array[l];
				array[l] ^= array[r];
			}
		}else{
			mergeSort(array, l, r/2);
			mergeSort(array, r/2+1, r);
			merge(array, l, r);
		}
		return array;
	}
	
	public static void merge(int[] array, int l, int r) {
		int[] lCopy = Arrays.copyOfRange(array, l, (r+l+1)/2);
		int[] rCopy = Arrays.copyOfRange(array, (r+l+1)/2, r+1);
		int lPointer = 0, rPointer = 0;
		for(int i=0; i<r-l+1; i++)
			if(rPointer >= rCopy.length ||
					lCopy[lPointer] <= rCopy[rPointer])
				array[l+i] = lCopy[lPointer++];
			else
				array[l+i] = rCopy[rPointer++];
	}
	
	public static void main(String[] args) {
		int[] array;
		
		array = mergeSort(new int[]{3, 6, 5, 4});
		assert(3 == array[0]);
		assert(4 == array[1]);
		assert(5 == array[2]);
		assert(6 == array[3]);
		
		array = mergeSort(new int[]{6, 7, 5, 4});
		assert(4 == array[0]);
		assert(5 == array[1]);
		assert(6 == array[2]);
		assert(7 == array[3]);
	}
}
