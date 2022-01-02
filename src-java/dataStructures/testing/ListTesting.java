package dataStructures.testing;

import dataStructures.linkedLists.LLQueue;
import dataStructures.linkedLists.LLStack;
import dataStructures.linkedLists.SLList;
import dataStructures.linkedLists.SNode;

public class ListTesting {

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
        SLList<Integer> list = new SLList<Integer>();
        
        list.append(20);
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(20);
        list.append(50);
        list.append(20);
        list.print();

        System.out.println("------");

        list.removeAll(20);
        list.print();
        System.out.println(list.hasCycle());

        System.out.println("------");
        
        SLList<Integer> loop = new SLList<Integer>();
        SNode<Integer> a = new SNode<Integer>(1);
        SNode<Integer> b = new SNode<Integer>(2);
        SNode<Integer> c = new SNode<Integer>(3);
        SNode<Integer> d = new SNode<Integer>(4);

        loop.insertTail(a);
        loop.insertTail(b);
        loop.insertTail(c);
        loop.insertTail(d);
        loop.insertTail(b);

        System.out.println(loop.hasCycle());
    }

}