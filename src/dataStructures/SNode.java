package dataStructures;

// Singly-linked (child) node implementation with generics
public class SNode<T> {

    private T data;
    private SNode<T> next;

    public SNode(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SNode<T> getNext() {
        return this.next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }

}