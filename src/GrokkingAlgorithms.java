import algorithms.BinarySearch;
import algorithms.Recursion;
import algorithms.SelectionSort;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class GrokkingAlgorithms {

	public static void main(String[] args) {
		binarySearch(10, new int[]{-10, -2, 1, 3, 4, 10, 25});

		smallestIndex(new Integer[]{5, 3, 6, 2, 10, -1, -100});

		selectionSort(new Integer[]{5, 3, 6, 2, 10, -1, -100});

		countdownWitRecursion(5);
	}

	private static void binarySearch(int item, int[] array) {
		BinarySearch bs = new BinarySearch();
		int itemIndex = bs.binarySearch(array, item);

		try {
			System.out.println("Binary search for number " +  item +  " in the array. its index is " + itemIndex + ".\n");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void smallestIndex(Integer[] array) {
		SelectionSort ss = new SelectionSort();
		int smallestIndex = ss.findSmallest(array);

		System.out.println("The smallest number of the array is " + array[smallestIndex] +  ". its index is " + smallestIndex + ".\n");
	}

	private static void selectionSort(Integer[] array) {
		SelectionSort ss = new SelectionSort();

		System.out.println("The selection sorting the array in ascending order: " + Arrays.toString(ss.selectionSort(array)) + ".\n");
	}

	private static void countdownWitRecursion(int from) {
		System.out.println("Countdown using recursion: ");

		Recursion recursion = new Recursion();
		recursion.countdown(from);

		System.out.println();
	}
}

