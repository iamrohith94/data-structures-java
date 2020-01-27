import java.util.Arrays;
import java.util.List;

/**
 * @author rohith reddy
 * @date 08/10/19
 */

public class TestBst {
    public static void main(String[] args) throws Exception {
        // Initialize a BST
        Bst<Integer> bst = new Bst<Integer>();

		/*
		Insert elements in order
		5, 3, 4, 2, 1, 8, 9, 7, 6
		 */
        int[] elements = {5, 3, 4, 2, 1, 8, 9, 6, 7};
        for (int i = 0; i < elements.length ; i++) {
            bst.insert(elements[i]);
        }

		/*
		Search for each of these elements
		*/
        for (int i = 0; i < elements.length ; i++) {
            if (!bst.search(elements[i])) {
                throw new Exception("Element not found : " + elements[i]);
            }
        }

        /*
        In order -> {1, 2, 3, 4, 5, 6, 7, 8, 9}
        */
        final List<Integer> inOrder = bst.inOrder();
        final List<Integer> expectedInorder = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 0; i < inOrder.size(); i++) {
            if (!inOrder.get(i).equals(expectedInorder.get(i))) {
                throw new Exception("Invalid In order at index : " + i);
            }
        }

        /*
        Pre order -> {5, 3, 2, 1, 4, 8, 6, 7, 9}
        */
        final List<Integer> preOrder = bst.preOrder();
        final List<Integer> expectedPreorder = Arrays.asList(5, 3, 2, 1, 4, 8, 6, 7, 9);
        for (int i = 0; i < preOrder.size(); i++) {
            if (!preOrder.get(i).equals(expectedPreorder.get(i))) {
                throw new Exception("Invalid Pre order at index : " + i);
            }
        }

        /*
        Post order -> {1, 2, 4, 3, 7, 6, 9, 8, 5}
        */
        final List<Integer> postOrder = bst.postOrder();
        final List<Integer> expectedPostorder = Arrays.asList(1, 2, 4, 3, 7, 6, 9, 8, 5);
        for (int i = 0; i < postOrder.size(); i++) {
            if (!postOrder.get(i).equals(expectedPostorder.get(i))) {
                throw new Exception("Invalid Pre order at index : " + i);
            }
        }

        /*
        Remove the following elements
        8 -> has two children
        2 -> has one left child
        6 -> has one right child
        4 -> leaf
         */
        int[] elementToRemove = {8, 2, 6, 4};
        for (int i = 0; i < elementToRemove.length ; i++) {
            bst.delete(elementToRemove[i]);
            if (bst.search(elementToRemove[i])) {
                throw new Exception("Element not deleted : " + elementToRemove[i]);
            }
        }

        System.out.println("Testing BST Successful");
    }
}
