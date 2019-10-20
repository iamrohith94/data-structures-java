/**
 * @author rohith reddy
 * @date 08/10/19
 */

class BstNode<T extends Comparable> extends Data<T> {
    private BstNode<T> left;
    private BstNode<T> right;

    BstNode(T value) {
        super(value);
        this.left = null;
        this.right = null;
    }

    BstNode<T> getLeft() {
        return left;
    }

    void setLeft(BstNode<T> left) {
        this.left = left;
    }

    BstNode<T> getRight() {
        return right;
    }

    void setRight(BstNode<T> right) {
        this.right = right;
    }

}
