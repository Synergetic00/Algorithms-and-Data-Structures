package dataStructures.linkedLists;

import java.util.EmptyStackException;

// Linked-list stack implementation
public class LLQueue<T> {

    int length;
    SNode<T> front = null;
    SNode<T> back = null;

    public LLQueue() {}

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueue(T data) {
        SNode<T> temp = new SNode<T>(data);
        if (isEmpty()) front = temp;
        else back.setNext(temp);
        back = temp;
        length++;
    }

    public T dequeue() {
        if (isEmpty()) throw new EmptyStackException();
        SNode<T> temp = front;
        front = front.getNext();
        length--;
        if (isEmpty()) back = null;
        return temp.getData();
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return front.getData();
    }

}