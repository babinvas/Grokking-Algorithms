package algorithms;

import java.util.Iterator;
import java.util.List;

public class QuickSort {
	public int euclideanAlgorithm(int sideA, int sideB) {
		if (sideB > sideA) {
			int helper = sideA;
			sideA = sideB;
			sideB = helper;
		}

		if (sideA % sideB == 0) {
			return sideB;
		} else {
			sideA = sideA % sideB;
			return euclideanAlgorithm(sideA, sideB);
		}
	}

	public int sumOfElement(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();

		if (iterator.hasNext()) {
			int element = iterator.next();
			iterator.remove();
			return element + sumOfElement(list);
		}

		return 0;
	}
}
