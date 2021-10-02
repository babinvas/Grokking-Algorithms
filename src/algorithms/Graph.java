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

	private void addToQueue(Map<String, String[]> graphs, String firstPerson, List<String> searchQueue) {
		if (graphs.containsKey(firstPerson)) {
			String[] persons = graphs.get(firstPerson);
			searchQueue.addAll(Arrays.asList(persons));
		}
	}

	private boolean isSeller(String person) {
		return person.contains("seller");
	}
}
