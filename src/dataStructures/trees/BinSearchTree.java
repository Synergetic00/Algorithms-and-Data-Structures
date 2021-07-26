package dataStructures.trees;

import dataStructures.linkedLists.LLStack;

public class BinSearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public void insert(T data) {
        BNode<T> node = new BNode<T>(data);

        if (root == null) {
            root = node;
            size++;
            return;
        } else {
            if (contains(data)) {
                return;
            } else {
                traverseAndInsert(root, node);
                size++;
            }
        }
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

    public void remove(T data) {
        if (!contains(data)) return;
        traverseAndRemove(this.root, data);
        size--;
    }

    private BNode<T> traverseAndRemove(BNode<T> origin, T data) {
        if(origin == null) return origin;
 
        if(data.compareTo(origin.getData()) < 0) {
            origin.setLeft(traverseAndRemove(origin.getLeft(), data));
        } else if(data.compareTo(origin.getData()) > 0) {
            origin.setRight(traverseAndRemove(origin.getRight(), data));
        } else {
            if(origin.children() == 0) {
                return null;
            } else if(origin.getLeft() == null) {
                return origin.getRight();
            } else if(origin.getRight() == null) {
                return origin.getLeft();
            } else {
                T minValue = minValue(origin.getRight());
                origin.setData(minValue);
                origin.setRight(traverseAndRemove(origin.getRight(), minValue));
            }
        }
 
        return origin;
    }

    private T minValue(BNode<T> origin) {
        if(origin.getLeft() != null) {
            return this.minValue(origin.getLeft());
        }
        return origin.getData();
    }

    private T maxValue(BNode<T> origin) {
        if(origin.getRight() != null) {
            return this.maxValue(origin.getRight());
        }
        return origin.getData();
    }

    public void display() {
        int maxLength = String.valueOf(this.maxValue(root)).length();
        final LLStack<BNode<T>> treeStack = new LLStack<BNode<T>>();
        treeStack.push(this.root);
        int index = 0;
        boolean isRowEmpty = false;
        while (!isRowEmpty) {
            int preceedingSpaces = getSpacingTerm((this.height() - index - 1), maxLength);
            int delimitingSpaces = getSpacingTerm((this.height() - index), maxLength);
            index++;
            final LLStack<BNode<T>> localStack = new LLStack<BNode<T>>();
            isRowEmpty = true;
            // Preceeding spaces
            for (int s = 0; s < preceedingSpaces; s++) System.out.print(" ");
            while (!treeStack.isEmpty()) {
                final BNode<T> temp = (BNode<T>)treeStack.pop();
                if (temp != null) {
                    int length = String.valueOf(temp.getData()).length();
                    for (int p = 0; p < maxLength - length; p++) System.out.print(" ");
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.children() > 0) isRowEmpty = false;
                } else {
                    for (int p = 0; p < maxLength; p++) System.out.print("_");
                    localStack.push(null);
                    localStack.push(null);
                }
                // Seperating spaces
                for (int y = 0; y < delimitingSpaces; ++y) System.out.print(" ");
            }
            System.out.println();
            while (!localStack.isEmpty()) treeStack.push(localStack.pop());
        }
        System.out.println();
    }

    private int getSpacingTerm(int index, int length) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += length * Math.pow(2, i);
        }
        return sum;
    }

    public void balance() {
        Object[] sortedArr = this.getOrderedList(INORDER).toArray();
        root = balance(sortedArr, 0, sortedArr.length-1);
    }

    @SuppressWarnings("unchecked")
    private BNode<T> balance(Object[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        BNode<T> node = new BNode<T>((T)arr[mid]);
        node.setLeft(balance(arr, start, mid-1));
        node.setRight(balance(arr, mid+1, end));
        return node;
    }
    
}