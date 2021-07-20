package dataStructures.trees;

import dataStructures.linkedLists.SLList;

public class BinSearchTree<T extends Comparable<? super T>> {

    BNode<T> root;
    int size = 0;

    public void insert(T data) {
        BNode<T> node = new BNode<T>(data);

        if (root == null) {
            root = node;
            return;
        } else {
            if (contains(data)) {
                return;
            } else {
                traverseAndInsert(root, node);
            }
        }
    }

    public boolean contains(T data) {
        return findNode(data) != null;
    }

    public BNode<T> findNode(T data) {
        return this.findNode(root, data);
    }

    private BNode<T> findNode(BNode<T> origin, T data) {
        if (origin == null || origin.getData().equals(data)) {
            return origin;
        } else if (origin.getData().compareTo(data) < 0) {
            return findNode(origin.getRight(), data);
        } else {
            return findNode(origin.getLeft(), data);
        }
    }

    private void traverseAndInsert(BNode<T> origin, BNode<T> node) {
        if (node.compareTo(origin) < 0) {
            if (origin.hasLeftNode()) {
                traverseAndInsert(origin.getLeft(), node);
            } else {
                origin.setLeft(node);
            }
        } else {
            if (origin.hasRightNode()) {
                traverseAndInsert(origin.getRight(), node);
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
        this.getInOrderList().print();
    }

    public SLList<T> getInOrderList() {
        SLList<T> list = new SLList<T>();
        this.getInOrderList(list, root);
        return list;
    }

    private void getInOrderList(SLList<T> list, BNode<T> node) {
        if (node != null) {
            getInOrderList(list, node.getLeft());
            list.addTail(node.getData());
            getInOrderList(list, node.getRight());
        }
    }
    
}