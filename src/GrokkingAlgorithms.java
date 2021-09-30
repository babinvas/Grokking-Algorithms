import algorithms.BinarySearch;
import algorithms.QuickSort;
import algorithms.Recursion;
import algorithms.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class GrokkingAlgorithms {

	public static void main(String[] args) {
		// Binary search
		findElement(10, new int[]{-10, -2, 1, 3, 4, 10, 25});

		findSmallestIndex(new Integer[]{5, 3, 6, 2, 10, -1, -100});

		// Selection sort
		sortInAscendingOrder(new Integer[]{5, 3, 6, 2, 10, -1, -100});

		// Recursion
		countdownWitRecursion(5);
		findFactorial(5);

		// Quick sort
		findLargestSquare(1680, 640);
		calculateSumOfValues(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10, -1, -100)));
		calculatesNumberElements(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10, -1, -100)));
		findLargestElement(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10, -1, -100)));
	}

	private static void findElement(int item, int[] array) {
		BinarySearch bs = new BinarySearch();
		int itemIndex = bs.findElement(array, item);

		try {
			System.out.println("Binary search for number " +  item +  " in the array. its index is " + itemIndex + ".\n");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void findSmallestIndex(Integer[] array) {
		SelectionSort ss = new SelectionSort();
		int smallestIndex = ss.findSmallestIndex(array);

		System.out.println("The smallest number of the array is " + array[smallestIndex] +  ". its index is " + smallestIndex + ".\n");
	}

	private static void sortInAscendingOrder(Integer[] array) {
		SelectionSort ss = new SelectionSort();

		System.out.println("The selection sorting the array in ascending order: " + Arrays.toString(ss.sortInAscendingOrder(array)) + ".\n");
	}

	private static void countdownWitRecursion(int from) {
		System.out.println("Countdown using recursion: ");

		Recursion recursion = new Recursion();
		recursion.countdown(from);

		System.out.println();
	}

	private static void findFactorial(int number) {
		Recursion recursion = new Recursion();

		System.out.println("Calculating the factorial of the number " + number + " using recursion.\n"
				+ "The factorial of the number is " + recursion.findFactorial(number) + ".\n");
	}

	private static void findLargestSquare(int sideA, int sideB) {
		QuickSort quickSort = new QuickSort();
		int SideOfSquare = quickSort.findLargestSquare(sideA, sideB);

		System.out.printf("The rectangle has sides %d and %d.\n"
				+ "The rectangle can be divided equally into the largest squares with side %d.\n\n", sideA, sideB, SideOfSquare);
	}

	private static void calculateSumOfValues(List<Integer> list) {
		QuickSort quickSort = new QuickSort();

		System.out.println("The sum of the element values of the array " + list + " is " + quickSort.calculateSumOfValues(list) + ".\n");
	}

	private static void calculatesNumberElements(List<Integer> list) {
		QuickSort quickSort = new QuickSort();

		System.out.println("The number of the elements of the array " + list + " is " + quickSort.calculatesNumberElements(list) + ".\n");
	}

	private static void findLargestElement(List<Integer> list) {
		QuickSort quickSort = new QuickSort();

		System.out.println("The largest element of the array " + list + " is " + quickSort.findLargestElement(list)+ ".\n");
	}
}
