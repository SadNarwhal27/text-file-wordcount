import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static Scanner search = new Scanner(System.in);
	
	public static int findWord(ArrayList<TopWord> list) {
		search = new Scanner(System.in);
		
		System.out.println("Search for a word in the file: ");
		String find = search.nextLine();
		int index = SortSearch.linearSearch(list, find);
		
		while(index == -1) {
			System.out.println("Word not found. Try another word: ");
			find = search.nextLine();
			index = SortSearch.linearSearch(list, find);
		}
		
		return index;
	}
	
	public static void mapWords(HashMap<String, Integer> wordCounts, String name) throws FileNotFoundException {
		File text = new File(name);
		Scanner scnr = new Scanner(text);

		// Loops through every line of the file
		while (scnr.hasNextLine()) {
			String line = scnr.nextLine();

			// Tokenize each word in the line and puts them in an array
			String[] words = line.split(" ");

			// Loops through every word in the previous array
			for (int i = 0; i < words.length; i++) {

				// Switches everything to lowercase for better calculation
				words[i] = words[i].toLowerCase();

				// Strips almost all punctuation and unnecessary characters from the tokens
				words[i] = words[i].replace(".", "").replace(",", "").replace("?", "").replace("!", "").replace(";", "")
						.replace(":", "").replace(",", "").replace("_", "").replace("--", "").replace(")", "")
						.replace("(", "");

				// Removes the odd question marks throughout the document
				if (words[i].contains("?") && words[i].length() == 1)
					words[i] = "";

				// Maps a key and value to the map
				if (wordCounts.containsKey(words[i])) {
					int count = wordCounts.get(words[i]);
					count++;
					wordCounts.put(words[i], count);
				} else {
					wordCounts.put(words[i], 1);
				}
			}
		}
		scnr.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();

		System.out.print("Please enter the name of the file: ");
		String name = search.nextLine();

		System.out.println();

		mapWords(wordCounts, name);

		// Removes any empty nodes from the map
		if (wordCounts.containsKey(""))
			wordCounts.remove("");

		// Creates an iterable set out of the map
		Iterable<String> wordSet = wordCounts.keySet();
		ArrayList<TopWord> top = new ArrayList<TopWord>();

		// Converts the contents of the map to an ArrayList for sorting
		for (String temp : wordSet) {
			String word = temp;
			int count = wordCounts.get(temp);
			TopWord mid = new TopWord(word, count);
			top.add(mid);
		}

		SortSearch.selectionSort(top);

		// Outputs the top 10 results
		for (int i = top.size() - 1; i > top.size() - 11; i--)
			System.out.println(top.get(i));
		
		boolean test = true;
		while(test) {
			int index = findWord(top);
			System.out.println(top.get(index));
		}
	}
}
