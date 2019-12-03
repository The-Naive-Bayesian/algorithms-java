package linked_list;

import java.util.NoSuchElementException;

public class LinkedList<T> {
  private Node first;
  private Node last;

  LinkedList() {
    first = null;
    last = null;
  }

  public void addToFront(T item) {
    Node newNode = new Node(item);

    if (first == null) {
      addInitialNode(newNode);
    } else {
      addNodeToFront(newNode);
    }
  }

  private void addNodeToFront(Node node) {
    Node oldFirst = first;
    first = node;
    node.setNext(oldFirst);
  }

  public void addToEnd(T item) {
    Node newNode = new Node(item);

    if (first == null) {
      addInitialNode(newNode);
    } else {
      addNodeToEnd(newNode);
    }
  }

  private void addNodeToEnd(Node newNode) {
    last.setNext(newNode);
    last = newNode;
  }

  private void addInitialNode(Node node) {
    first = node;
    last = node;
  }

  public T removeFirst() {
    if (first == null) throw new NoSuchElementException();
    Node oldFirst = popFirst();

    return oldFirst.getItem();
  }

  private Node popFirst() {
    Node oldFirst = first;
    first = oldFirst.getNext();

    return oldFirst;
  }

  private class Node {
    T item;
    Node next;

    Node(T item) {
      this.item = item;
    }

    void setNext(Node node) {
      next = node;
    }

    Node getNext() {
      return next;
    }

    boolean hasNext() {
      return next != null;
    }

    T getItem() {
      return item;
    }
  }
}
