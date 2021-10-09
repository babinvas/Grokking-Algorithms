import algorithms.*;

import java.util.*;

public class GrokkingAlgorithms {

	public static void main(String[] args) {
		// Binary search
		findElement(10, new int[]{-10, -2, 1, 3, 4, 10, 25});

		findSmallestIndex(new Integer[]{5, 3, 6, 2, 10, -1, -100});

		// Selection sort
		selectionSortInAscendingOrder(new Integer[]{5, 3, 6, 2, 10, -1, -100});

		// Recursion
		countdownWitRecursion(5);
		findFactorial(5);

		// Quick sort
		findLargestSquare(1680, 640);
		calculateSumOfValues(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10, -1, -100)));
		calculatesNumberElements(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10, -1, -100)));
		findLargestElement(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10, -1, -100)));
		quickSortInAscendingOrder(new ArrayList<>(Arrays.asList(5, 3, 6, 2, 10, -1, -100)));

		// Graphs
		breadthFirstSearch();
		dijkstraAlgorithmExample1();
		dijkstraAlgorithmExample2();
		dijkstraAlgorithmExample3();

		// Greedy algorithm
		findBestStations();

		// Dynamic programming
		findLongestCommonSubstring("hish", new String[]{"fish", "vista"});
		findLongestCommonSubstring("horis", new String[]{"fort", "fish"});
		findLongestCommonSubsequence("hisw", new String[]{"fish", "vista"});
		findLongestCommonSubsequence("fosh", new String[]{"fort", "fish"});

		// k-nearest neighbors algorithm
		findDistanceToNeighbors();
	}

	private static void findElement(int item, int[] array) {
		BinarySearch bs = new BinarySearch();
		int itemIndex = bs.findElement(array, item);

		try {
			System.out.println("Binary search for number " +  item +  " in the array " + Arrays.toString(array) + ". its index is " + itemIndex + ".\n");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void findSmallestIndex(Integer[] array) {
		SelectionSort ss = new SelectionSort();
		int smallestIndex = ss.findSmallestIndex(array);

		System.out.println("The smallest number of the array " + Arrays.toString(array) + " is " + array[smallestIndex] +  ". its index is " + smallestIndex + ".\n");
	}

	private static void selectionSortInAscendingOrder(Integer[] array) {
		SelectionSort ss = new SelectionSort();

		System.out.println("The selection sorting the array " + Arrays.toString(array) +" in ascending order: " + Arrays.toString(ss.sortInAscendingOrder(array)) + ".\n");
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

	private static void quickSortInAscendingOrder(List<Integer> list) {
		QuickSort quickSort = new QuickSort();

		System.out.println("The quick sorting the array " + list + " in ascending order: " + quickSort.sortInAscendingOrder(list)+ ".\n");
	}

	private static void breadthFirstSearch() {
		Map<String, String[]> graphs = new HashMap<>();

		graphs.put("you", new String[]{"alice", "bob", "claire_seller"});
		graphs.put("bob", new String[]{"anuj", "peggy"});
		graphs.put("alice", new String[]{"peggy"});
		graphs.put("claire_seller", new String[]{"thom_seller", "jonny"});
		graphs.put("anuj", new String[]{});
		graphs.put("peggy", new String[]{});
		graphs.put("thom_seller", new String[]{});
		graphs.put("jonny", new String[]{});

		Graph graph = new Graph();
		String firstPerson = "you";

		try {
			System.out.println(graph.breadthFirstSearch(graphs, firstPerson) + " is а mango seller!\n");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void dijkstraAlgorithmExample1() {
		Map<String, Map<String, Integer>> graphs = new HashMap<>();
		String start = "start";
		String end = "end";

		Map<String, Integer> neighbors = new HashMap<>();
		neighbors.put("a", 6);
		neighbors.put("b", 2);
		graphs.put(start, neighbors);

		neighbors = new HashMap<>();
		neighbors.put(end, 1);
		graphs.put("a", neighbors);

		neighbors = new HashMap<>();
		neighbors.put("a", 3);
		neighbors.put(end, 5);
		graphs.put("b", neighbors);

		graphs.put(end, null);

		Graph graph = new Graph();
		System.out.println("The fastest path from the start to end is " + graph.dijkstraAlgorithm(graphs, start, end) + ".\n");
	}

	private static void dijkstraAlgorithmExample2() {
		Map<String, Map<String, Integer>> graphs = new HashMap<>();
		String start = "start";
		String end = "end";

		Map<String, Integer> neighbors = new HashMap<>();
		neighbors.put("a", 5);
		neighbors.put("b", 2);
		graphs.put(start, neighbors);

		neighbors = new HashMap<>();
		neighbors.put("c", 4);
		neighbors.put("d", 2);
		graphs.put("a", neighbors);

		neighbors = new HashMap<>();
		neighbors.put("d", 7);
		graphs.put("b", neighbors);

		neighbors = new HashMap<>();
		neighbors.put("d", 6);
		neighbors.put(end, 3);
		graphs.put("c", neighbors);

		neighbors = new HashMap<>();
		neighbors.put(end, 1);
		graphs.put("d", neighbors);

		graphs.put(end, null);

		Graph graph = new Graph();
		System.out.println("The fastest path from the start to end is " + graph.dijkstraAlgorithm(graphs, start, end) + ".\n");
	}

	private static void dijkstraAlgorithmExample3() {
		Map<String, Map<String, Integer>> graphs = new HashMap<>();
		String start = "start";
		String end = "end";

		Map<String, Integer> neighbors = new HashMap<>();
		neighbors.put("a", 10);
		graphs.put(start, neighbors);

		neighbors = new HashMap<>();
		neighbors.put("b", 20);
		graphs.put("a", neighbors);

		neighbors = new HashMap<>();
		neighbors.put("c", 1);
		neighbors.put(end, 30);
		graphs.put("b", neighbors);

		neighbors = new HashMap<>();
		neighbors.put("a", 1);
		graphs.put("c", neighbors);

		graphs.put(end, null);

		Graph graph = new Graph();
		System.out.println("The fastest path from the start to end is " + graph.dijkstraAlgorithm(graphs, start, end) + ".\n");
	}

	private static void findBestStations() {
		Set<String> statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "са", "az"));

		Map<String, Set<String>> stations = new HashMap<>();
		stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
		stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
		stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "са")));
		stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
		stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

		GreedyAlgorithm ga = new GreedyAlgorithm();
		System.out.println("The best stations is " + ga.greedyAlgorithm(statesNeeded, stations) + ".\n");
	}

	private static void findLongestCommonSubstring(String mainWord, String[] words) {
		DynamicProgramming dynamicProgramming = new DynamicProgramming();
		System.out.printf("The longest common substring of the word '%s' and the array %s is '%s'.\n\n", mainWord, Arrays.toString(words), dynamicProgramming.findLongestCommonSubstring(mainWord, words));
	}

	private static void findLongestCommonSubsequence(String mainWord, String[] words) {
		DynamicProgramming dynamicProgramming = new DynamicProgramming();
		System.out.printf("The longest common subsequence of the word '%s' and the array %s is '%s'.\n\n", mainWord, Arrays.toString(words), dynamicProgramming.findLongestCommonSubsequence(mainWord, words));
	}

	private static void findDistanceToNeighbors() {
		Map<String, int[]> users = new HashMap<>();
		users.put("Priyanka", new int[] {3, 4, 4, 1, 4});
		users.put("Justin", new int[] {4, 3, 5, 1, 5});
		users.put("Morpheus", new int[] {2, 5, 1, 3, 1});

		KNearestNeighborsAlgorithm kNearestNeighborsAlgorithm = new KNearestNeighborsAlgorithm();
		String mainUser = "Priyanka";
		Map<String, Integer> distanceToNeighbors = kNearestNeighborsAlgorithm.findDistanceToNeighbors(mainUser, users);

		System.out.println("The users are:");
		users.forEach((key, value) -> System.out.println(key + " : " + Arrays.toString(value)));
		System.out.printf("The distance from '%s' to other users : '%s'.\n\n", mainUser, distanceToNeighbors.toString());
	}
}
