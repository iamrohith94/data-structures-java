import java.util.ArrayList;
import java.util.List;

/**
 * @author rohith reddy
 * @date 08/10/19
 */

class Bst<T extends Comparable> implements DataStructure<T> {
    private BstNode<T> root;

    public BstNode<T> getRoot() {
        return root;
    }

    @Override
    public void insert(T data) {
        if (root == null) {
            root = new BstNode<T>(data);
            return;
        }
        insert(root, data);
    }

    @Override
    public boolean search(T data) {
        return search(root, data);
    }

    @Override
    public void delete(T data) {
        this.root = delete(root, data);

    }

    List<T> inOrder() {
        final List<T> order = new ArrayList<T>();
        inOrder(root, order);
        return order;
    }

    List<T> preOrder() {
        final List<T> order = new ArrayList<T>();
        preOrder(root, order);
        return order;
    }

    List<T> postOrder() {
        final List<T> order = new ArrayList<T>();
        postOrder(root, order);
        return order;
    }

    //--------------------------------------- PRIVATE METHODS --------------------------------------- //


    private void inOrder(BstNode<T> root, List<T> order) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), order);
        order.add(root.getValue());
        inOrder(root.getRight(), order);
    }

    private void preOrder(BstNode<T> root, List<T> order) {
        if (root == null) {
            return;
        }
        order.add(root.getValue());
        preOrder(root.getLeft(), order);
        preOrder(root.getRight(), order);
    }

    private void postOrder(BstNode<T> root, List<T> order) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft(), order);
        postOrder(root.getRight(), order);
        order.add(root.getValue());
    }

    private void insert(BstNode<T> root, T data) {
        final int comparison = root.compareTo(data);
        if (comparison == 1) {
            if (root.getLeft() == null) {
                root.setLeft(new BstNode<T>(data));
            }
            insert(root.getLeft(), data);
            return;
        }
        if (comparison == -1) {
            if (root.getRight() == null) {
                root.setRight(new BstNode<T>(data));
            }
            insert(root.getRight(), data);
        }
        //Note: If the value is already in the tree, do not do anything.
    }

    private boolean search(BstNode<T> root, T data) {
        if (root == null) {
            return false;
        }
        final int comparison = root.compareTo(data);
        if (comparison == 0) {
            return true;
        }
        if (comparison == 1 && root.getLeft() != null) {
            return search(root.getLeft(), data);
        }
        if (comparison == -1 && root.getRight() != null) {
            return search(root.getRight(), data);
        }
        return false;
    }

    private BstNode<T> delete(BstNode<T> root, T value) {
        if (root == null) {
            return null;
        }
        final int comparison = root.compareTo(value);
        if (comparison == 0) {
            if (root.getLeft() == null) {
                return root.getRight();
            }
            if (root.getRight() == null) {
                return root.getLeft();
            }
            // if the node has two children, replace the node with the least value from right subtree
            final T minValue = getMinValue(root.getRight());
            root.setValue(minValue);
            root.setRight(delete(root.getRight(), minValue));
        }
        if (comparison == -1) {
            root.setRight(delete(root.getRight(), value));
        }
        if (comparison == 1) {
            root.setLeft(delete(root.getLeft(), value));
        }
        return root;
    }

    private T getMinValue(BstNode<T> root) {
        BstNode<T> rootCopy = root;
        while (rootCopy.getLeft() != null) {
            rootCopy = rootCopy.getLeft();
        }
        return rootCopy.getValue();
    }
}
