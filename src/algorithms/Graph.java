package algorithms;

import java.util.*;

public class Graph {
	public String breadthFirstSearch(Map<String, String[]> graphs, String firstPerson) {
		LinkedList<String> searchQueue = new LinkedList<>();
		ArrayList<String> searched = new ArrayList<>();
		addToQueue(graphs, firstPerson, searchQueue);

		while(!searchQueue.isEmpty()) {
			String person = searchQueue.pollFirst();

			if (!searched.contains(person)) {
				if (isSeller(person)) {
					return person;
				}

				addToQueue(graphs, person, searchQueue);
				searched.add(person);
			}
		}

		throw new NoSuchElementException("There is no such person.");
	}

	public int dijkstraAlgorithm(Map<String, Map<String, Integer>> graphs, String start, String end) {
		Map<String, Integer> costs = new HashMap<>();
		Map<String, String> parents = new HashMap<>();
		ArrayList<String> processed = new ArrayList<>();

		for (Map.Entry<String, Map<String, Integer>> gr : graphs.entrySet()) {
			costs.put(gr.getKey(), null);
			parents.put(gr.getKey(), null);
		}

		Map<String, Integer> startGraph = graphs.get(start);

		for (Map.Entry<String, Integer> graph : startGraph.entrySet()) {
			costs.put(graph.getKey(), graph.getValue());
			parents.put(graph.getKey(), start);
		}

		String node = findLowestCostNode(costs, processed);

		while (node != null) {
			int cost = costs.get(node);
			Map<String, Integer> neighbors = graphs.get(node);

			if (neighbors != null) {
				for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
					String neighborNode = neighbor.getKey();
					Integer neighborCost = neighbor.getValue();

					int newCost = cost + neighborCost;

					if (costs.get(neighborNode) == null || costs.get(neighborNode) > newCost) {
						costs.put(neighborNode, newCost);
						parents.put(neighborNode, node);
					}
				}
			}

			processed.add(node);
			node = findLowestCostNode(costs, processed);
		}

		return costs.get(end);
	}

	private void addToQueue(Map<String, String[]> graphs, String firstPerson, List<String> searchQueue) {
		if (graphs.containsKey(firstPerson)) {
			String[] persons = graphs.get(firstPerson);
			searchQueue.addAll(Arrays.asList(persons));
		}
	}

	private boolean isSeller(String person) {
		return person.contains("seller");
	}

	private String findLowestCostNode(Map<String, Integer> costs, ArrayList<String> processed) {
		int marker = 0;
		int lowestCost = 0;
		String lowestCostNode = null;

		for (Map.Entry<String, Integer> node : costs.entrySet()) {
			String nodeName = node.getKey();
			Integer nodeCost = node.getValue();

			if (nodeCost != null && marker == 0 && !processed.contains(nodeName)) {
				lowestCost = nodeCost;
				lowestCostNode = nodeName;
				marker++;
			}

			if (nodeCost != null && nodeCost < lowestCost && !processed.contains(nodeName)) {
				lowestCost = nodeCost;
				lowestCostNode = nodeName;
			}
		}

		return lowestCostNode;
	}
}
