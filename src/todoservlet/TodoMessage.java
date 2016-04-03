package todoservlet;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "randomMessage")
@XmlType(propOrder ={"words","wordCount"})
public class TodoMessage {
	private String words;
	private int wordCount;
	
	public TodoMessage(){}

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
		this.wordCount = words.trim().split("//s+").length;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	@Override
	public String toString() {
		return "RandomMessage [words=" + words + ", wordCount=" + wordCount + "]";
	};
	
	
}
