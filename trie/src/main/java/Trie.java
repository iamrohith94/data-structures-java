class Trie implements DataStructure<String> {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    @Override
    public void insert(String data) {
        TrieNode curr = root;
        for (char c : data.toCharArray()) {
            curr.set(c - 'a');
            curr = curr.get(c - 'a');
        }
        curr.setWordCount(curr.getWordCount() + 1);
    }

    @Override
    public boolean search(String data) {
        TrieNode curr = root;
        for (char c : data.toCharArray()) {
            if (curr.get(c - 'a') == null) {
                return false;
            }
            curr = curr.get(c - 'a');
        }
        return curr.getWordCount() > 0;
    }

    @Override
    public void delete(String data) {
        if (!this.search(data)) {
            throw new RuntimeException("Data not found");
        }
        TrieNode curr = root;
        for (char c : data.toCharArray()) {
            curr.remove(c - 'a');
            curr = curr.get(c - 'a');
            if (curr == null) {
                break;
            }
        }
        if (curr != null) {
            curr.setWordCount(curr.getWordCount() - 1);
        }
    }

    @Override
    public boolean isValid() {
        return true;
    }

    public int prefixCount(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.get(c - 'a') == null) {
                return 0;
            }
            curr = curr.get(c - 'a');
        }
        return curr.getPrefixCount();
    }

    public int getWordCount() {
        return getWordCount(root);
    }

    private int getWordCount(TrieNode root) {
        int count = 0;
        for (TrieNode node : root.getChildren()) {
            if (node == null) {
                continue;
            }
            if (node.getWordCount() > 0) {
                count += node.getWordCount();
            }
            count += getWordCount(node);
        }
        return count;
    }
}