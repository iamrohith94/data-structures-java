import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class TestTrie {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();

        // Insert words
        final List<String> words = Arrays.asList("car", "care", "car", "ice", "iceberg", "atom", "atomic");
        for (String word : words) {
            trie.insert(word);
        }

        // Count words
        Assert.assertEquals(words.size(), trie.getWordCount());

        // Find words
        for (String word : words) {
            Assert.assertTrue(trie.search(word));
        }

        // Num of words with a given prefix
        Assert.assertEquals(3, trie.prefixCount("car"));
        Assert.assertEquals(2, trie.prefixCount("ice"));
        Assert.assertEquals(1, trie.prefixCount("iceberg"));

        // Remove "car"
        trie.delete("car");
        Assert.assertTrue(trie.search("car"));
        trie.insert("car");

        // Remove & insert "ice"
        trie.delete("ice");
        Assert.assertFalse(trie.search("ice"));
        trie.insert("ice");
        Assert.assertTrue(trie.search("ice"));

        // Remove all
        for (String word : words) {
            System.out.println("Removing : " + word);
            trie.delete(word);
        }
        for (String word : words) {
            Assert.assertFalse(trie.search(word));
        }
    }

}
