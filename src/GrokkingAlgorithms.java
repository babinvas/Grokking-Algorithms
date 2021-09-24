import algorithms.BinarySearch;
import algorithms.Recursion;
import algorithms.SelectionSort;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class GrokkingAlgorithms {

	public static void main(String[] args) {
		binarySearch();

		smallestIndex();

		selectionSort();

		countdownWitRecursion();
	}

	private static void binarySearch() {
		int[] array1 = new int[]{-10, -2, 1, 3, 4, 10, 25};
		int item = 10;

		BinarySearch bs = new BinarySearch();
		int itemIndex = bs.binarySearch(array1, item);

		try {
			System.out.println(itemIndex +  " -> " + array1[itemIndex] + "\n");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void smallestIndex() {
		Integer[] array = new Integer[]{5, 3, 6, 2, 10, -1, -100};

		SelectionSort ss = new SelectionSort();
		int smallestIndex = ss.findSmallest(array);

		System.out.println(smallestIndex +  " -> " + array[smallestIndex] + "\n");
	}

	private static void selectionSort() {
		Integer[] array = new Integer[]{5, 3, 6, 2, 10, -1, -100};

		SelectionSort ss = new SelectionSort();

		System.out.println(Arrays.toString(ss.selectionSort(array)) + "\n");
	}

	private static void countdownWitRecursion() {
		int from = 5;

		Recursion recursion = new Recursion();
		recursion.countdown(from);
	}
}
