package dataStructures.trees;

public class BinSearchTree<T extends Comparable<? super T>> {

    BNode<T> root;
    int size = 0;

    public void insert(T data) {
        BNode<T> node = new BNode<T>(data);

        if (root == null) {
            root = node;
        } else {
            if (contains(data)) return;
            traverseAndInsert(node, root);
        }
    }

    public boolean contains(T data) {
        return findNode(data) != null;
    }

    public BNode<T> findNode(T data) {
        BNode<T> current = root;
        while (current != null) {
            if (current.getData().equals(data)) return current;
            else if (current.getData().compareTo(data) < 0) current = current.getLeft();
            else current = current.getRight();
        }
        return null;
    }

    private void traverseAndInsert(BNode<T> node, BNode<T> origin) {
        if (node.compareTo(origin) < 0) {
            if (origin.hasLeftNode()) {
                traverseAndInsert(node, node.getLeft());
            } else {
                origin.setLeft(node);
            }
        } else {
            if (origin.hasRightNode()) {
                traverseAndInsert(node, node.getRight());
            } else {
                origin.setRight(node);
            }
        }
    }

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

    public void printInOrder() {
        this.traverseInOrder(root);
    }

    public void traverseInOrder(BNode<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node.getData());
            traverseInOrder(node.getRight());
        }
    }
    
}