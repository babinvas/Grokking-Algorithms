package algorithms;

public class SelectionSort {
	public int findSmallest(Integer[] array) {
		Integer smallest = array[0];
		int smallestIndex = 0;

		for (int i = 1; i < array.length; i++) {
			if (smallest == null) {
				smallest = array[i];
				smallestIndex = i;
			}

			if (array[i] != null && smallest > array[i]) {
				smallest = array[i];
				smallestIndex = i;
			}
		}

		return smallestIndex;
	}
}
