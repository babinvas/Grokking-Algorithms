package algorithms;

import java.util.NoSuchElementException;

public class BinarySearch {
	public int findElement(int[] list, int item) {
		int low = 0;
		int high = list.length - 1;

		int mid;
		int guess;

		while (low <= high) {
			mid = (low + high) / 2;
			guess = list[mid];

			if (guess == item) {
				return mid;
			} else if (guess > item)  {
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}

		throw new NoSuchElementException("The array has no such element.");
	}
}
