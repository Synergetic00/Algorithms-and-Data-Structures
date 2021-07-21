package dataStructures.trees;

import java.util.Arrays;

import dataStructures.linkedLists.SLList;

public class BinSearchTree<T extends Comparable<? super T>> {

    public static final int PREORDER = -1, INORDER = 0, POSTORDER = 1;

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

    public void printPreOrder() {
        System.out.println(Arrays.toString(this.getOrderedList(PREORDER).toArray()));
    }

    public void printInOrder() {
        System.out.println(Arrays.toString(this.getOrderedList(INORDER).toArray()));
    }

    public void printPostOrder() {
        System.out.println(Arrays.toString(this.getOrderedList(POSTORDER).toArray()));
    }

    public SLList<T> getOrderedList(int order) {
        SLList<T> list = new SLList<T>();
        if (order < 0) {
            this.getPreOrderList(list, root);
        } else if (order > 0) {
            this.getPostOrderList(list, root);
        } else {
            this.getInOrderList(list, root);
        }
        return list;
    }

    private void getPreOrderList(SLList<T> list, BNode<T> node) {
        if (node != null) {
            list.addTail(node.getData());
            getPreOrderList(list, node.getLeft());
            getPreOrderList(list, node.getRight());
        }
    }

    private void getInOrderList(SLList<T> list, BNode<T> node) {
        if (node != null) {
            getInOrderList(list, node.getLeft());
            list.addTail(node.getData());
            getInOrderList(list, node.getRight());
        }
    }

    private void getPostOrderList(SLList<T> list, BNode<T> node) {
        if (node != null) {
            getPostOrderList(list, node.getLeft());
            getPostOrderList(list, node.getRight());
            list.addTail(node.getData());
        }
    }

    public void remove(T data) {
        if (!contains(data)) return;
        root = traverseAndRemove(root, data);
    }

    private BNode<T> traverseAndRemove(BNode<T> origin, T data) {
        if (origin == null) {
            return null;
        }

        if (origin.getData().compareTo(data) < 0) {
            origin.setRight(traverseAndRemove(origin.getRight(), data));
        } else if (origin.getData().compareTo(data) > 0) {
            origin.setLeft(traverseAndRemove(origin.getRight(), data));
        } else {
            switch (origin.children()) {
                case 0:
                    origin = null;
                    break;
                case 1:
                    if (origin.hasLeftNode()) {
                        origin = origin.getLeft();
                    } else {
                        origin = origin.getRight();
                    }
                    break;
                case 2:
                    BNode<T> temp = origin;
                    BNode<T> minNodeForRight = minNode(temp.getRight());
                    origin.setData(minNodeForRight.getData());
                    origin.setRight(traverseAndRemove(origin.getRight(), minNodeForRight.getData()));
                    break;
                default:
                    break;
            }
        }

        return origin;
    }

    private BNode<T> minNode(BNode<T> origin) {
        if (origin.getLeft() == null) {
            return origin;
        } else {
            return minNode(origin.getLeft());
        }
    }
    
}