package algorithms;

public class SelectionSort {
	public int findSmallest(int[] array) {
		int smallest = array[0];
		int smallestIndex = 0;

		for (int i = 1; i < array.length; i++) {
			if (smallest > array[i]) {
				smallest = array[i];
				smallestIndex = i;
			}
		}

		return smallestIndex;
	}
}
