package dataStructures.linkedLists;

import dataStructures.SNode;

// Singly Linked List
public class SLList<T> {

    SNode<T> head;
    int length;

    //// Adding
    //// Removing
    
    // Insert a node at the given index
    public void addAt(T data, int index) {
        SNode<T> temp = new SNode<T>(data);
        SNode<T> current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        length++;
    }
    
    // Append a node to the list O(n)
    public void addTail(T data) {
        SNode<T> temp = new SNode<T>(data);
        if (this.head == null) head = temp;
        else this.getTail().setNext(temp);
        length++;
    }

    // Other names
    public void append(T data) { this.addTail(data); }

    // Prepend a node to the list O(1)
    public void addHead(T data) {
        SNode<T> temp = new SNode<T>(data);
        temp.setNext(head);
        head = temp;
        length++;
    }

    // Other names
    public void prepend(T data) { this.addHead(data); }

    public void removeAt(int index) {
        SNode<T> temp = head;
        for(int i = 0; i< index -1; i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
    }

    public T peekHead() {
        return null;
    }

    public T peekTail() {
        return null;
    }

    public boolean contains(T data) {
        return this.occurences(data) == 0;
    }

    public int occurences(T data) {
        return 0;
    }

    public SNode<T> getHead() {
        return head;
    }

    public SNode<T> getAt(int index) {
        SNode<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    public SNode<T> getTail() {
        SNode<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp;
    }

    public void print() {
        if (head != null) {
            SNode<T> current = head;
            while(current.getNext() != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
            System.out.println(current.getData());
        }
    }

    /*public boolean hasCycle() {
        if (head == null) return false;
        SNode<T> slow, fast;

        slow = fast = head;
    }*/

}