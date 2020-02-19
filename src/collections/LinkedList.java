package collections;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
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

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator(this);
  }

  private class LinkedListIterator implements Iterator<T> {
    Node currentNode;


    LinkedListIterator(LinkedList<T> linkedList) {
      currentNode = linkedList.first;
    }

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public T next() {
      T item = currentNode.item;
      currentNode = currentNode.next;

      return item;
    }
  }

  private class Node {
    T item;
    Node next;

    Node(T item) {
      this.item = item;
    }
  }
}
