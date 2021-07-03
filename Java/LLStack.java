package Java;

import java.util.EmptyStackException;

// Linked-list queue implementation
public class LLStack<T> {

    int length;
    SNode<T> top = null;

    public LLStack() {}

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(T data) {
        SNode<T> temp = new SNode<T>(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        SNode<T> temp = top;
        top = top.getNext();
        length--;
        return temp.getData();
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getData();
    }

}