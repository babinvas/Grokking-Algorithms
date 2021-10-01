package algorithms;

import java.util.ArrayList;
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

	public Integer findLargestElement(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();

		if (iterator.hasNext()) {
			Integer element = iterator.next();
			iterator.remove();

			Integer pastElement = findLargestElement(list);

			if (pastElement == null) {
				return element;
			}

			return element > pastElement ? element : pastElement;
		}

		return null;
	}

	public List<Integer> sortInAscendingOrder(List<Integer> list) {
		int length = list.size();

		if (length < 2) {
			return list;
		}

		int middle = length / 2;
		Integer pivot = list.get(middle);
		List<Integer> less = new ArrayList<>();
		List<Integer> greater = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			if (i == middle) {
				continue;
			}

			Integer element = list.get(i);

			if (element > pivot) {
				greater.add(element);
			} else {
				less.add(element);
			}
		}

		less = sortInAscendingOrder(less);
		greater = sortInAscendingOrder(greater);

		less.add(pivot);
		less.addAll(greater);

		return less;
	}
}
