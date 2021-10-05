package algorithms;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedyAlgorithm {
	public Set<String> greedyAlgorithm(Set<String> statesNeeded, Map<String, Set<String>> stations) {
		Set<String> finalStations = new HashSet<>();

		while(!statesNeeded.isEmpty()) {
			String bestStation = "";
			Set<String> statesCovered = new HashSet<>();

			for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
				Set<String> covered = new HashSet<>(station.getValue());
				covered.retainAll(statesNeeded);

				if (covered.size() > statesCovered.size()) {
					bestStation = station.getKey();
					statesCovered = covered;
				}
			}

			statesNeeded.removeAll(statesCovered);
			finalStations.add(bestStation);
		}

		return finalStations;
	}
}
