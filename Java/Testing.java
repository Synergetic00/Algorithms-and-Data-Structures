package Java;

public class Testing {

    public static void main(String[] args) {
        testLLStack();
        testLLQueue();
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

}