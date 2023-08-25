package Seminar003.CW.Seminar.Exercise001;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;

public class OneWayList<T> implements Iterable<T> {

    private Node head;

    public void addFirst(T value) {
        Node newNode = new Node();
        newNode.value = value;

        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void add(T value) {
        Node node = new Node();
        node.value = value;

        if (head == null) {
            head = node;
        } else {
            Node lastNode = head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node node = head;

                while (node.next != null) {
                    if (node.next.next == null) {
                        node.next = null;
                        return;
                    }
                    node = node.next;
                }
            }
        }
    }

    public boolean contains(T value) {
        Node node = head;

        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void sort(Comparator<T> comparator) {
        Node node = head;

        while (node != null) {
            Node minValueNode = node;
            Node nodeNext = node.next;

            while (nodeNext != null) {
                if (comparator.compare(nodeNext.value, minValueNode.value) > 0) {
                    minValueNode = nodeNext;
                }
                nodeNext = nodeNext.next;
            }
            if (minValueNode != node) {
                T buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }
            node = node.next;
        }
    }


    public void reverse() {
        if (head == null){
            return;
        }

        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = currentNode.next;

        while (nextNode != null){
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.next;
        }
        currentNode.next = previousNode;
        head = currentNode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = head;
        stringBuilder.append('[');

        while (node != null) {
            stringBuilder.append(node.value);
            node = node.next;
            if (node != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new OneWayListIterator();
    }

    public int length() {
        int counter = 0;
        Node node = head;

        while (node.next != null) {
            node = node.next;
            counter++;
        }
        return counter;
    }

    private Node getLast() {
        Node node = head;

        if (node == null) {
            return null;
        }

        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private class Node {
        public Node next;
        public T value;
    }

    private class OneWayListIterator implements Iterator<T> {
        Node current;

        public OneWayListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
