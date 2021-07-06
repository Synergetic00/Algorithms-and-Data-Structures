package dataStructures.linkedLists;

// Singly Linked List
public class SLList<T> {

    SNode<T> head;
    int length;

    //// Inserting - adding actual nodes into the list

    /**
     * Put a node object at the beginning of the list
     * @param node
     */
    public void insertHead(SNode<T> node) {
        SNode<T> temp = node;
        temp.setNext(head);
        head = temp;
        length++;
    }

    /**
     * Put a node object at the end of the list
     * @param node
     */
    public void insertTail(SNode<T> node) {
        SNode<T> tail = node;
        if (this.head == null) {
            head = tail;
            length++;
            return;
        }
        SNode<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(tail);
        length++;
        
    }

    /**
     * Put a node object in the list at the given index
     * @param node
     * @param index
     */
    public void insertAt(SNode<T> node, int index) {
        if (index == 0) this.insertHead(node);
        SNode<T> temp = node;
        SNode<T> current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        length++;
    }

    //// Adding - putting a new node in the list

    /**
     * Put a new node with the given data at the start of the list
     * @param data
     */
    public void addHead(T data) {
        this.insertHead(new SNode<T>(data));
    }

    /**
     * Put a new node with the given data at the end of the list
     * @param data
     */
    public void addTail(T data) {
        this.insertTail(new SNode<T>(data));
    }

    /**
     * Put a new node with the given data as its value at the given index
     * @param data
     * @param index
     */
    public void addAt(T data, int index) {
        this.insertAt(new SNode<T>(data), index);
    }

    //// Extracting - remove and return the node's value

    /**
     * Get the data of the node at the start of the list
     * @return
     */
    public T extractHead() {
        if (head == null) return null;
        SNode<T> temp = head;
        head = head.getNext();
        temp.setNext(null);
        length--;
        return temp.getData();
    }

    /**
     * Get the data of the node at the end of the list
     * @return
     */
    public T extractTail() {
        if (head == null) return null;
        SNode<T> temp = head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        SNode<T> output = temp.getNext();
        temp.setNext(null);
        length--;
        return output.getData();
    }

    /**
     * Get the data of the node at the given index
     * @param index
     * @return
     */
    public T extractAt(int index) {
        if (index == 0) this.extractHead();
        SNode<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        SNode<T> output = temp.getNext();
        temp.setNext(temp.getNext().getNext());
        length--;
        return output.getData();
    }

    //// Getting - get the value of a certain node

    public T getHead() {
        return head.getData();
    }

    public T getTail() {
        SNode<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public T getAt(int index) {
        SNode<T> temp = head;
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
        SNode<T> temp = head;
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
        SNode<T> temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        length--;
    }

    public void removeFirst(T data) {
        if (head == null || !this.contains(data)) return;
        SNode<T> curr = head;
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
        SNode<T> curr = head;
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
        SNode<T> curr = head;
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
        SNode<T> temp = head;
        if (temp.getData().equals(data)) count++;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getData().equals(data)) count++;
        }
        return count;
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

    public Object[] toArray() {
        Object[] output = new Object[length];
        int index = 0;
        if (head != null) {
            SNode<T> current = head;
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
        SNode<T> slow, fast;
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