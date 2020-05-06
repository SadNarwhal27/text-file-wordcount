import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
		
		Scanner fileName = new Scanner(System.in);
		System.out.print("Please enter the name of the file: ");
		String name = fileName.nextLine();
		fileName.close();
		
		System.out.println();
		
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
				words[i] = words[i].replace(".", "").replace(",", "").replace("?", "").replace("!", "").replace(";", "").replace(":", "").replace(",", "").replace("_", "").replace("--", "").replace(")", "").replace("(", "");

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
		
		// Removes any empty nodes from the map
		if (wordCounts.containsKey(null))
			wordCounts.remove(null);

		// Creates an iterable set out of the map and outputs every mapped node
		Iterable<String> wordSet = wordCounts.keySet();
		for (String temp : wordSet) {
			System.out.println(wordCounts.get(temp) + ", " + temp);
		}
	}

}
