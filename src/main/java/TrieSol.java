import java.util.ArrayList;
import java.util.List;

public class TrieSol {
    List<List<String>> suggestedProducts(String[] products,
                                         String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
    public static void main(String args[]) {
        TrieSol a = new TrieSol();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> l = a.suggestedProducts(products, searchWord);

        for (List<String> ll : l) {
            for (String s : ll) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }
}
