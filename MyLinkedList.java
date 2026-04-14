public class MyLinkedList<E> {

    private Node<E> head, tail;
    private int size = 0;

    /** Create an empty list */
    public MyLinkedList() {
    }

    /** Return the number of elements in the list */
    public int size() {
        return size;
    }

    /** Add element to the beginning */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);

        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    /** Add element to the end */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;
    }

    /** Add element at index */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            Node<E> newNode = new Node<>(e);
            Node<E> prev = current.previous;

            prev.next = newNode;
            newNode.previous = prev;

            newNode.next = current;
            current.previous = newNode;

            size++;
        }
    }

    /** Remove first element */
    public E removeFirst() {
        if (size == 0) return null;

        E temp = head.element;

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        size--;
        return temp;
    }

    /** Remove last element */
    public E removeLast() {
        if (size == 0) return null;

        E temp = tail.element;

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }

        size--;
        return temp;
    }

    /** Remove element at index */
    public E remove(int index) {
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<E> prev = current.previous;
        Node<E> next = current.next;

        prev.next = next;
        next.previous = prev;

        size--;
        return current.element;
    }

    /** Return element at index */
    public E get(int index) {
        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.element;
    }

    /** Print list forward */
    public void printForward() {
        Node<E> current = head;

        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }

        System.out.println();
    }

    /** Print list backward */
    public void printBackward() {
        Node<E> current = tail;

        while (current != null) {
            System.out.print(current.element + " ");
            current = current.previous;
        }

        System.out.println();
    }

    /** Node class */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }
}
