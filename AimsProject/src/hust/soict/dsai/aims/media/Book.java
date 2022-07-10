package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

import hust.soict.dsai.aims.exception.*;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

    private String content = "";
    private int contentLength;
    private List<String> contentTokens;
    private Map<String,Integer> wordFrequency;

	public void addAuthor(String authorName) throws IllegalItemException {
        if (!this.authors.stream().anyMatch(authorName::equalsIgnoreCase)) {
            this.authors.add(authorName);
            System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");
        } else {
            throw new IllegalItemException(authorName + " is already in the list of authors of " + this.getTitle() + ".");
        }
	}
	
	public void removeAuthor(String authorName) throws IllegalItemException {
        if (this.authors.stream().anyMatch(authorName::equalsIgnoreCase)) {
            this.authors.removeIf(author -> author.equalsIgnoreCase(authorName));
            System.out.println(authorName + " has been removed from the " + this.getTitle() + " list of authors.");
        } else {
            throw new IllegalItemException(authorName + " is not in the list of authors of " + this.getTitle() + ".");
        }
	}

    public void setProcessContent(String content) {
        this.content = content;
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
        String content = "";
        int contentLength = 0;
        String contentTokens = "";
        String wordFrequencyOutput = "";
        if (this.content != "") {
            content = this.content;
            contentLength = this.contentLength;
            contentTokens = this.contentTokens.toString().replace("[","").replace("]","");
            for (Map.Entry<String, Integer> entry : this.wordFrequency.entrySet()) {
                wordFrequencyOutput += ("\t\t\'" + entry.getKey() + "\': " + entry.getValue() + "\n");
            }    
        }
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
                             this.authors.toString().replace("[","").replace("]",""),
                             content,
                             contentLength,
                             contentTokens,
                             wordFrequencyOutput));
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
