package dataStructures;

import dataStructures.linkedLists.LLQueue;
import dataStructures.linkedLists.LLStack;
import dataStructures.linkedLists.SLList;

public class Testing {

    public static void main(String[] args) {
        testLLStack();
        testLLQueue();
        testSLList();
    }

    public static void testLLStack() {
        System.out.println("\nLinked List Stack:");
        LLStack<Object> stack = new LLStack<Object>();

        stack.push(5);
        stack.push("Hello");
        stack.push('a');
        stack.push(null);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void testLLQueue() {
        System.out.println("\nLinked List Queue:");
        LLQueue<Object> queue = new LLQueue<Object>();

        queue.enqueue(5);
        queue.enqueue("Hello");
        queue.enqueue('a');
        queue.enqueue(null);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    public static void testSLList() {
        System.out.println("\nSingly Linked List:");
        SLList<Object> list = new SLList<Object>();

        list.append(5);
        list.append(10);
        list.append(15);
        list.append(20);
        list.print();
        list.addAt(100, 2);
        System.out.println("********");
        list.print();
        System.out.println("********");
        list.removeAt(2);
        list.print();
        System.out.println("********");
        list.prepend(50);
        list.print();
    }

}