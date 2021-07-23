package dataStructures.trees;

import java.util.Arrays;

import dataStructures.linkedLists.LLQueue;
import dataStructures.linkedLists.SLList;

@SuppressWarnings("unused")
public class BinaryTree<T extends Comparable<? super T>> {

    public static final int PREORDER = -1, INORDER = 0, POSTORDER = 1;

    BNode<T> root;
    int size = 0;

    public void insert(T data) {
        BNode<T> node = new BNode<T>(data);

        if (root == null) {
            root = node;
            return;
        } else {
            traverseAndInsert(root, node);
        }

        size++;
    }

    public boolean contains(T data) {
        return this.findNode(data) != null;
    }

    public BNode<T> findNode(T data) {
        return this.findNode(root, data);
    }

    private BNode<T> findNode(BNode<T> origin, T data) {
        return null;
    }

    private void traverseAndInsert(BNode<T> origin, BNode<T> node) {
        LLQueue<BNode<T>> queue = new LLQueue<BNode<T>>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            origin = queue.dequeue();
            if (!origin.hasLeftNode()) {
                origin.setLeft(node);
            } else {
                queue.enqueue(origin.getLeft());
            }
            if (!origin.hasRightNode()) {
                origin.setRight(node);
            } else {
                queue.enqueue(origin.getLeft());
            }
        }
    }

	public void clear() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

    public int size() {
        return size;
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
        size--;
    }

    private BNode<T> traverseAndRemove(BNode<T> origin, T data) {
        return null;
    }

    private T minValue(BNode<T> origin) {
        return null;
    }

    private T maxValue(BNode<T> origin) {
        return null;
    }

    public int height() {
        if (this.isEmpty()) {
            return 0;
        } else {
            BNode<T> origin = root;
            return height(origin);
        }
    }

    private int height(BNode<T> origin) {
        return 0;
    }

    public void display() {
        
    }

    private int getSpacingTerm(int index, int length) {
        return 0;
    }
    
}