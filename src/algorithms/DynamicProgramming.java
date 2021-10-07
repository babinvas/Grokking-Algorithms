package algorithms;

import javax.swing.*;
import java.util.SplittableRandom;

public class DynamicProgramming {
	public String findLongestCommonSubstring(String mainWord, String[] words) {
		int longestCommonSubstring = 0;
		String neededWord = "";

		for (String word : words) {
			int longest = findLongestCommonSubstring(mainWord, word);

			if (longestCommonSubstring < longest) {
				longestCommonSubstring = longest;
				neededWord = word;
			}
		}

		return neededWord + ":" + longestCommonSubstring;
	}

	public String findLongestCommonSubsequence(String mainWord, String[] words) {
		int longestCommonSubsequence = 0;
		String neededWord = "";

		for (String word : words) {
			int longest = findLongestCommonSubsequence(mainWord, word);

			if (longestCommonSubsequence < longest) {
				longestCommonSubsequence = longest;
				neededWord = word;
			}
		}

		return neededWord + ":" + longestCommonSubsequence;
	}

	private int findLongestCommonSubstring(String word1, String word2) {
		int longestCommonSubstring = 0;

		int wordLength1 = word1.length();
		int wordLength2 = word2.length();
		int[][] cell = new int[wordLength1][wordLength2];

		for (int i = 0; i < wordLength1; i++) {
			char wordLetter1 = word1.charAt(i);
			for (int j = 0; j < wordLength2; j++) {
				char wordLetter2 = word2.charAt(j);

				if (!(i == 0 || j == 0) && wordLetter1 == wordLetter2) {
					cell[i][j] = cell[i - 1][j - 1] + 1;
					longestCommonSubstring = Math.max(longestCommonSubstring, cell[i][j]);
				} else if (wordLetter1 == wordLetter2) {
					cell[i][j] = 1;
					longestCommonSubstring = 1;
				} else {
					cell[i][j] = 0;
				}
			}
		}

		return longestCommonSubstring;
	}

	private int findLongestCommonSubsequence(String word1, String word2) {
		int longestCommonSubstring = 0;

		int wordLength1 = word1.length();
		int wordLength2 = word2.length();
		int[][] cell = new int[wordLength1][wordLength2];

		for (int i = 0; i < wordLength1; i++) {
			char wordLetter1 = word1.charAt(i);
			for (int j = 0; j < wordLength2; j++) {
				char wordLetter2 = word2.charAt(j);

				int beforeJCell = 0;
				int beforeICell = 0;
				int beforeIJCell = 0;

				if (i != 0 && j != 0) {
					beforeJCell = cell[i][j - 1];
					beforeICell = cell[i - 1][j];
					beforeIJCell = cell[i - 1][j - 1];
				} else if (i == 0 && j != 0) {
					beforeJCell = cell[i][j - 1];
				} else if (i != 0) {
					beforeICell = cell[i - 1][j];
				}

				if (wordLetter1 == wordLetter2) {
					cell[i][j] = beforeIJCell + 1;
					longestCommonSubstring = Math.max(longestCommonSubstring, cell[i][j]);
				} else {
					cell[i][j] = Math.max(beforeICell, beforeJCell);
				}
			}
		}

		return longestCommonSubstring;
	}
}
