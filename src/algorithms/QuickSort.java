package algorithms;

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
}
