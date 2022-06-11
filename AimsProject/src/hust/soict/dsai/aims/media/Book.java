package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

    private String content;
    private int contentLength;
    private List<String> contentTokens;
    private Map<String,Integer> wordFrequency;

	public void addAuthor(String authorName) {
        if (!this.authors.stream().anyMatch(authorName::equalsIgnoreCase)) {
            this.authors.add(authorName);
            System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");
        } else {
            System.out.println(authorName + " is already in the list of authors of " + this.getTitle() + ".");
        }
	}
	
	public void removeAuthor(String authorName) {
        if (this.authors.stream().anyMatch(authorName::equalsIgnoreCase)) {
            this.authors.removeIf(author -> author.equalsIgnoreCase(authorName));
            System.out.println(authorName + " has been removed from the " + this.getTitle() + " list of authors.");
        } else {
            System.out.println(authorName + " is not in the list of authors of " + this.getTitle() + ".");
        }
	}

    public void setContent(String content) {
        this.content = content;
        this.processContent();
    }

    public void processContent() {
        // Split the content into words
        String[] words = this.content.split("\\W+");

        // Add words to this.contentTokens
        this.contentTokens = Arrays.asList(words);

        // Write the number of words to this.contentLength
        this.contentLength = this.contentTokens.size();
        
        // Build a map of words and their frequencies
        Map<String, Integer> map = new HashMap<String, Integer>();
        Integer ONE = new Integer(1);
        for (String word : this.contentTokens) {
            String key = word.toLowerCase();
            Integer frequency = map.get(key);
            if (frequency == null) {
                frequency = ONE;
            } else {
                int value = frequency.intValue();
                frequency = new Integer(value + 1);
            }
            map.put(key, frequency);
        }
        this.wordFrequency = new TreeMap<String, Integer>(map);
    }

    public String toString() {
        return(String.format("[$%f]:\n" + 
                             "\tBook\n" +
                             "\tTitle: %s\n" +
                             "\tCategory: %s\n" +
                             "\tAuthor: %s\n" +
                             "\tContent: %s\n" +
                             "\tContent Length: %d\n" +
                             "\tContent Tokens: %s\n" +
                             "\tWord Frequency: \n%s"
                             ,
                             this.getCost(),
                             this.getTitle(), 
                             this.getCategory(),
                             this.getAuthor(),
                             this.getContent(),
                             this.getContentLength(),
                             this.getContentTokens(),
                             this.getWordFrequency()));
    }

    public String getAuthor() {
        return this.authors.toString().replace("[","").replace("]","");
    }

    public String getContent() {
        return this.content;
    }

    public int getContentLength() {
        return this.contentLength;
    }

    public String getContentTokens() {
        return this.contentTokens.toString().replace("[","").replace("]","");
    }

    public String getWordFrequency() {
        String output = "";
        for (Map.Entry<String, Integer> entry : this.wordFrequency.entrySet()) {
            output += ("\t\t\'" + entry.getKey() + "\': " + entry.getValue() + "\n");
        }
        return output;
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

}
