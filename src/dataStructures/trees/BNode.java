package dataStructures.trees;

// Binary tree node implementation with generics
public class BNode<T extends Comparable<? super T>> {
    
    private T data;
    private BNode<T> left;
    private BNode<T> right;

    public BNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BNode<T> left) {
        this.left = left;
    }

    public BNode<T> getRight() {
        return this.right;
    }

    public void setRight(BNode<T> right) {
        this.right = right;
    }

    public boolean isLeafNode() {
        return left == null && right == null;
    }

    public boolean hasLeftNode() {
        return left != null;
    }

    public boolean hasRightNode() {
        return right != null;
    }

    public int compareTo(BNode<T> other) {
        return this.getData().compareTo(other.getData());
    }

}
