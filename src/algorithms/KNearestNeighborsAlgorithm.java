package algorithms;

import java.util.HashMap;
import java.util.Map;

public class KNearestNeighborsAlgorithm {
	public Map<String, Integer> findDistanceToNeighbors(String mainUser, Map<String, int[]> users) {
		Map<String, Integer> distanceToNeighbors = new HashMap<>();

		for (Map.Entry<String, int[]> user : users.entrySet()) {
			if (!user.getKey().equals(mainUser)) {
				int distance = (int) Math.round(findDistance(users.get(mainUser), user.getValue()));
				distanceToNeighbors.put(user.getKey(), distance);
			}
		}

		return distanceToNeighbors;
	}

	private double findDistance(int[] mainUser, int[] user) {
		int distance = 0;

		for (int i = 0; i < mainUser.length; i++) {
			distance += square(mainUser[i] - user[i]);
		}

		return Math.sqrt(distance);
	}

	private int square(int a) {
		return a * a;
	}
}
