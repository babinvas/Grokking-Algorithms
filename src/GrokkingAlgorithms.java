import algorithms.BinarySearch;
import algorithms.SelectionSort;

import java.util.NoSuchElementException;

public class GrokkingAlgorithms {

	public static void main(String[] args) {
		int[] array1 = new int[]{-10, -2, 1, 3, 4, 10, 25};
		int item = 10;

		BinarySearch bs = new BinarySearch();
		int itemIndex = bs.binarySearch(array1, item);

		try {
			System.out.println(itemIndex +  " -> " + array1[itemIndex] + "\n");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		Integer[] array2 = new Integer[]{5, 3, 6, 2, 10, -1, -100};

		SelectionSort ss = new SelectionSort();
		int smallestIndex = ss.findSmallest(array2);

		System.out.println(smallestIndex +  " -> " + array2[smallestIndex] + "\n");
	}
}
