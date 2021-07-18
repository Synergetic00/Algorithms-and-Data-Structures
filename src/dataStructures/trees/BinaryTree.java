package dataStructures.trees;

public class BinaryTree<T extends Comparable<? super T>> {

    BNode<T> root;

    public void add(T data) {
        root = addAt(root, data);
    }

    public BNode<T> addAt(BNode<T> node, T data) {
        if (node == null) return new BNode<T>(data);
        switch (node.getData().compareTo(data)) {
            case 1: {
                node.setLeft(addAt(node.getLeft(), data));
            }
            case -1: {
                node.setRight(addAt(node.getRight(), data));
            }
            default: {
                return node;
            }
        }
    }

    public void printPreOrder() {
        this.traversePreOrder(root);
    }

    public void traversePreOrder(BNode<T> node) {
        if (node != null) {
            traversePreOrder(node.getLeft());
            System.out.print(" " + node.getData());
            traversePreOrder(node.getRight());
        }
    }
    
}