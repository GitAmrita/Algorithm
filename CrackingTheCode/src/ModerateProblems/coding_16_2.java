package ModerateProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by amritachowdhury on 7/2/17.
 */
public class coding_16_2 {

    public Map<String, Integer> preprocessedTable = new HashMap<>();

    public void run() {
        List<String> book = parseBook();
        setPreprocessedTable(book);
        int freq = findFrequencyOfWord("the");
        System.out.println(freq);
        freq = findFrequencyOfWord("a");
        System.out.println(freq);
        freq = findFrequencyOfWord("topic");
        System.out.println(freq);
    }

    private List<String> parseBook() {
        String unParsedBook =
                " A paragraph is a number of sentences grouped together and relating to one topic. Or, a group of related sentences that develop a single point." +
                "\n" +
                "This definition shows that the paragraphs of compositions are not mere arbitrary divisions. The division of a chapter into paragraphs must be made according to the changes of ideas introduced." +
                "\n" +
                "There is, therefore, no rule as to the length of a paragraph. It may be short or long according to the necessity of the case. A paragraph may consist of a single sentence or of many sentences." +
                "\n" +
                "In this aspect, the paragraphs of a piece of prose differ from the stanzas of verses of a poem. The stanza of a poem are usually of the same length and pattern but paragraphs are long or short according to the amount of matter to be expressed under each head." +
                "\n" +
                "The Principle of Good Paragraph Structure: ";
        List<String> book = new LinkedList<>();
        String[] page = unParsedBook.split("\n");

        for (String p : page) {
            String[] words = p.split(" ");
            for (String g : words) {
                book.add(g);
            }
        }
        return book;
    }

    private void setPreprocessedTable(List<String> book) {
        for (String s : book) {
            if (s.isEmpty()) {
                continue;
            }
            if (preprocessedTable.get(s.toLowerCase()) == null) {
                preprocessedTable.put(s, 1);
            } else {
                int freq = preprocessedTable.get(s.toLowerCase());
                preprocessedTable.put(s.toLowerCase(), freq + 1);
            }
        }
    }

    private int findFrequencyOfWord(String word) {
        Integer frequency = preprocessedTable.get(word.toLowerCase());
        return frequency == null ? 0 : frequency;
    }
}
