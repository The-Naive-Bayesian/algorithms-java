package collections;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
  private Node<T> first;

  public Node<T> getFirst() {
    return first;
  }

  public void insertFirst(T item) {
    Node<T> newNode = new Node<>(item);

    if (first == null) {
      first = newNode;
    } else {
      newNode.next = first;
      first = newNode;
    }
  }

  public T removeFirst() {
    if (first == null) return null;

    T item = first.item;
    first = first.next;

    return item;
  }

  // Problem 1.3.19
  T removeLast() {
    if (first == null) return null;

    Node<T> current = first;
    Node<T> prev = first;

    while (current.next != null) {
      prev = current;
      current = current.next;
    }

    T returnValue = current.item;
    prev.next = null;

    return returnValue;
  }

  // Problem 1.3.20
  public void delete(int index) {
    if (first == null) return;
    if (index == 0) {
      first = first.next;
      return;
    }

    Node current = first;
    Node prev = first;

    int i = 0;
    while (i < index && current.next != null) {
      prev = current;
      current = current.next;
      i++;
    }

    prev.next = current.next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
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
    Node<T> currentNode;


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
}
