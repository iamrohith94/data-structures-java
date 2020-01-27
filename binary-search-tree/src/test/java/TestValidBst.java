import org.junit.Assert;

public class TestValidBst {

    private static boolean isValid(BstNode<Integer> root, Integer min, Integer max) {
        if (root == null || root.getValue() == null) {
            return true;
        }

        if (root.getValue().compareTo(min) < 0 || root.getValue().compareTo(max) > 0) {
            return false;
        }
        return isValid(root.getLeft(), min, root.getValue()) && isValid(root.getRight(), root.getValue(), max);
    }

    public static void main(String[] args) throws Exception {

        // Initialize a BST
        final Bst<Integer> bst = new Bst<>();

        // Insert elements in order
        final int[] elements = {3, 1, 4, 2};
        for (int element : elements) {
            bst.insert(element);
        }

        // Validate
        Assert.assertTrue(isValid(bst.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
