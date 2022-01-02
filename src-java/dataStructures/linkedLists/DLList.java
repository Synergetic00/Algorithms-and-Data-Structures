package dataStructures.linkedLists;

// Doubly Linked List
public class DLList<T> {

    DNode<T> head;
    DNode<T> tail;
    int length;

    //// Inserting - adding actual nodes into the list

    public void insertHead(DNode<T> node) {
        DNode<T> temp = node;
        temp.setNext(head);
        head = temp;
        length++;
    }

    public void insertTail(DNode<T> node) {
        DNode<T> temp = node;
        temp.setPrev(tail);
        head = temp;
        length++;
        
    }

    public void insertAt(DNode<T> node, int index) {
        if (index == 0) this.insertHead(node);
        DNode<T> temp = node;
        DNode<T> current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        length++;
    }

    //// Adding - putting a new node in the list

    public void addHead(T data) {
        this.insertHead(new DNode<T>(data));
    }

    public void addTail(T data) {
        this.insertTail(new DNode<T>(data));
    }

    public void addAt(T data, int index) {
        this.insertAt(new DNode<T>(data), index);
    }

    //// Extracting - remove and return the node's value

    public T extractHead() {
        if (head == null) return null;
        DNode<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        return temp.getData();
    }

    public T extractTail() {
        if (head == null) return null;
        DNode<T> temp = head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        DNode<T> output = temp.getNext();
        temp.setNext(null);
        length--;
        return output.getData();
    }

    public T extractAt(int index) {
        if (index == 0) this.extractHead();
        DNode<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        DNode<T> output = temp.getNext();
        temp.setNext(temp.getNext().getNext());
        length--;
        return output.getData();
    }

    //// Getting - get the value of a certain node

    public T getHead() {
        return head.getData();
    }

    public T getTail() {
        DNode<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public T getAt(int index) {
        DNode<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    //// Removing - delete node and discard the value

    public void removeHead() {
        head = head.getNext();
        length--;
    }

    public void removeTail() {
        if (head == null) return;
        DNode<T> temp = head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        length--;
    }

    public void removeAt(int index) {
        if (index == 0) {
            this.removeHead();
            return;
        }
        DNode<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        length--;
    }

    public void removeFirst(T data) {
        if (head == null || !this.contains(data)) return;
        DNode<T> curr = head;
        int index = 0;
        while (curr.getNext() != null) {
            if (curr.getData().equals(data)) {
                this.removeAt(index);
                length--;
                return;
            }
            curr = curr.getNext();
            index++;
        }
        if (curr.getData().equals(data)) {
            this.removeAt(index);
            length--;
            return;
        }
    }

    public void removeLast(T data) {
        if (head == null || !this.contains(data)) return;
        DNode<T> curr = head;
        int index = 0, lastIndex = 0;
        while (curr.getNext() != null) {
            if (curr.getData().equals(data)) {
                lastIndex = index;
            }
            curr = curr.getNext();
            index++;
        }
        if (curr.getData().equals(data)) {
            lastIndex = index;
            this.removeAt(lastIndex);
            length--;
            return;
        }
    }

    public void removeAll(T data) {
        if (head == null || !this.contains(data)) return;
        DNode<T> curr = head;
        int index = 0;
        while (curr.getNext() != null) {
            if (curr.getData().equals(data)) {
                this.removeAt(index);
            } else {
                index++;
            }
            curr = curr.getNext();
        }
        if (curr.getData().equals(data)) {
            this.removeAt(index);
        }
    }

    // Other methods - what is convenient

    public boolean contains(T data) {
        return !(this.occurences(data) == 0);
    }

    public int occurences(T data) {
        int count = 0;
        DNode<T> temp = head;
        if (temp.getData().equals(data)) count++;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getData().equals(data)) count++;
        }
        return count;
    }

    public void print() {
        if (head != null) {
            DNode<T> current = head;
            while(current.getNext() != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }
            System.out.println(current.getData());
        }
    }

    public Object[] toArray() {
        Object[] output = new Object[length];
        int index = 0;
        if (head != null) {
            DNode<T> current = head;
            while(current.getNext() != null) {
                output[index] = current;
                current = current.getNext();
                index++;
            }
            System.out.println(output[index] = current);
        }
        return output;
    }

    public int size() {
        return length;
    }

    public boolean hasCycle() {
        if (head == null) return false;
        DNode<T> slow, fast;
        slow = fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) return true;
        }
        return false;
    }

    // Other aliases

    public void append(T data) { this.addTail(data); }
    public void prepend(T data) { this.addHead(data); }
    
}