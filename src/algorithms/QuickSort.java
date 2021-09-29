package algorithms;

import java.util.Iterator;
import java.util.List;

public class QuickSort {
	public int findLargestSquare(int sideA, int sideB) {
		// Euclidean algorithm

		if (sideB > sideA) {
			int helper = sideA;
			sideA = sideB;
			sideB = helper;
		}

		if (sideA % sideB == 0) {
			return sideB;
		} else {
			sideA = sideA % sideB;
			return findLargestSquare(sideA, sideB);
		}
	}

	public int calculateSumOfValues(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();

		if (iterator.hasNext()) {
			int element = iterator.next();
			iterator.remove();
			return element + calculateSumOfValues(list);
		}

		return 0;
	}

	public int calculatesNumberElements(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();

		if (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
			return 1 + calculatesNumberElements(list);
		}

		return 0;
	}
}
