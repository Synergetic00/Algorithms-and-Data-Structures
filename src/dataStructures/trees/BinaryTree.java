package dataStructures.trees;

import java.util.Arrays;

import dataStructures.linkedLists.LLQueue;
import dataStructures.linkedLists.LLStack;
import dataStructures.linkedLists.SLList;

@SuppressWarnings("unused")
public class BinaryTree<T extends Comparable<T>> {

    public static final int PREORDER = -1, INORDER = 0, POSTORDER = 1;

    BNode<T> root;
    int size = 0;

    public void insert(T data) {
        traverseAndInsert(root, data);
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

    private void traverseAndInsert(BNode<T> temp, T data) {
        if (temp == null) {
            root = new BNode<T>(data);;
            return;
        }
        
        LLQueue<BNode<T>> q = new LLQueue<BNode<T>>();
        q.enqueue(temp);
 
        while (!q.isEmpty()) {
            temp = q.dequeue();
 
            if (temp.getLeft() == null) {
                temp.setLeft(new BNode<T>(data));
                break;
            } else {
                q.enqueue(temp.getLeft());
            }
 
            if (temp.getRight() == null) {
                temp.setRight(new BNode<T>(data));
                break;
            } else {
                q.enqueue(temp.getRight());
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

    public void printBreadthFirst() {
        System.out.println(Arrays.toString(this.getBreadthFirstList().toArray()));
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

    public SLList<T> getBreadthFirstList() {
        SLList<T> list = new SLList<T>();
        getBreadthFirstList(list, root);
        return list;
    }

    private void getBreadthFirstList(SLList<T> list, BNode<T> origin) {
        if (root == null) return;
        LLQueue<BNode<T>> queue = new LLQueue<BNode<T>>();
        queue.clear();
        queue.enqueue(root);
        while(!queue.isEmpty()) {
            BNode<T> node = queue.dequeue();
            list.addTail(node.getData());
            if(node.getLeft() != null) queue.enqueue(node.getLeft());
            if(node.getRight() != null) queue.enqueue(node.getRight());
        }
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
        traverseAndRemove(root, data);
        size--;
    }

    private void traverseAndRemove(BNode<T> origin, T data) {
        if (origin == null) return;

		if (origin.getLeft() == null && origin.getRight() == null) {
			if (origin.getData().equals(data)) {
				origin=null;
				return;
			} else {
				return;
            }
		}

        LLQueue<BNode<T>> q = new LLQueue<BNode<T>>();
		q.enqueue(root);
		BNode<T> temp = null, keyNode = null;

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.getData().equals(data)) {
                keyNode = temp;
            }

			if (temp.getLeft() != null) {
                q.enqueue(temp.getLeft());
            }

			if (temp.getRight() != null) {
				q.enqueue(temp.getRight());
            }
		}

		if (keyNode != null) {
			T x = temp.getData();
			removeLeaf(origin, temp);
			keyNode.setData(x);
		}
    }

    private void removeLeaf(BNode<T> origin, BNode<T> toDelete) {
        LLQueue<BNode<T>> q = new LLQueue<BNode<T>>();
		q.enqueue(root);

		BNode<T> temp = null;

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp == toDelete) {
				temp = null;
				return;
			}
			if (temp.getRight() != null) {
				if (temp.getRight() == toDelete) {
					temp.setRight(null);
					return;
				} else {
					q.enqueue(temp.getRight());
                }
			}

			if (temp.getLeft() != null) {
				if (temp.getLeft() == toDelete) {
					temp.setLeft(null);
					return;
				} else {
                    q.enqueue(temp.getLeft());
                }
			}
		}
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
        if (origin == null) return 0;
        return Math.max(height(origin.getLeft()), height(origin.getRight())) + 1;
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
    }

    private int getSpacingTerm(int index, int length) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += length * Math.pow(2, i);
        }
        return sum;
    }
    
}