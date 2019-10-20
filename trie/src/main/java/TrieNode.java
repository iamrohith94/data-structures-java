import java.util.Arrays;
import java.util.List;

class TrieNode {
    private int prefixCount;
    private int wordCount;
    private List<TrieNode> children;

    TrieNode() {
        this.prefixCount = 0;
        this.wordCount = 0;
        this.children = Arrays.asList(new TrieNode[26]);
    }

    int getPrefixCount() {
        return prefixCount;
    }

    void setPrefixCount(int count) {
        this.prefixCount = count;
    }

    int getWordCount() {
        return wordCount;
    }

    void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    List<TrieNode> getChildren() {
        return children;
    }

    TrieNode get(int i) {
        if (i >= 0 && i < 26) {
            return children.get(i);
        }
        return null;
    }

    void set(int i) {
        if (children.get(i) == null) {
            children.set(i, new TrieNode());
        }
        children.get(i).prefixCount++;
    }

    void remove(int i) {
        if (children.get(i) == null) {
            return;
        }
        if (children.get(i).getPrefixCount() == 1) {
            children.set(i, null);
            return;
        }
        children.get(i).prefixCount--;
    }
}
