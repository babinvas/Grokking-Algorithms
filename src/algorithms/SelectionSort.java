package algorithms;

public class SelectionSort {
	public int findSmallestIndex(Integer[] array) {
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

	public Integer[] sortInAscendingOrder(Integer[] array) {
		Integer[] newArray = new Integer[array.length];
		int smallestIndex;

		for (int i = 0; i < array.length; i++) {
			smallestIndex = findSmallestIndex(array);
			newArray[i] = array[smallestIndex];
			array[smallestIndex] = null;
		}

		return newArray;
	}
}
