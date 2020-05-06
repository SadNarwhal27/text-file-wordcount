import java.util.ArrayList;

public class SortSearch {
	public static void selectionSort(ArrayList<TopWord> list) {
		// Initializes the smallest index tracker and temporary CD
		int indexSmallest = 0;
		TopWord word;
		
		// Goes through each index of the ArrayList
		for (int i = 0; i < list.size(); ++i) {
			indexSmallest = i;
			
			// Finds the smallest index after i
			for (int j = i + 1; j < list.size(); ++j)
				if (list.get(j).getCount() < list.get(indexSmallest).getCount())
					indexSmallest = j;
			
			// Repositions indexes
			word = list.get(i);
			list.set(i, list.get(indexSmallest));
			list.set(indexSmallest, word);
			
		}
	}
	
	
	public static int linearSearch(ArrayList<TopWord> list, String word) {
		for (int i = 0; i < list.size(); i++) {
			String search = list.get(i).getWord();
			if (search.compareTo(word) == 0)
				return i; // Found position
		}

		return -1; // Number not found
	}
}
