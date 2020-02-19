package collections;

public class LinkedList<T> {
  private Node first;
  private Node last;

  void insertFirst(T item) {
    Node newNode = new Node(item);

    if (first == null) {
      first = newNode;
      last = newNode;
    } else {
      newNode.next = first;
      first = newNode;
    }
  }

  void insertLast(T item) {
    Node newNode = new Node(item);

    if (last == null) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
  }

  T removeFirst() {
    if (first == null) return null;

    T item = first.item;
    first = first.next;

    if (first == null) last = null;

    return item;
  }

  boolean isEmpty() {
    return first == null;
  }

  int size() {
    int count = 0;
    Node currentNode = first;

    while (currentNode != null) {
      count++;
      currentNode = currentNode.next;
    }

    return count;
  }

  private class Node {
    T item;
    Node next;

    Node(T item) {
      this.item = item;
    }
  }
}
