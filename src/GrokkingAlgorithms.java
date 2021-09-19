import algorithms.BinarySearch;

import java.util.NoSuchElementException;

public class GrokkingAlgorithms {

	public static void main(String[] args) {
		int[] array = new int[]{-10, -2, 1, 3, 4, 10, 25};
		int item = 100;
		BinarySearch bs = new BinarySearch();

		try {
			System.out.println(bs.binarySearch(array, item));
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
}
