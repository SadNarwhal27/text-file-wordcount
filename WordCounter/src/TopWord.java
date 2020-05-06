
public class TopWord {
	String word;
	int count;
	
	public String getWord() {
		return this.word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getCount() {
		return this.count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public TopWord() {
		this.word = "";
		count = 0;
	}
	
	public TopWord(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public String toString() {
		return this.word + " - " + this.count;
	}
}
