package linked_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
  private Node first;
  private Node last;

  public LinkedList() {
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

  public Node getFirst() {
    return first;
  }

  private Node popFirst() {
    Node oldFirst = first;
    first = oldFirst.getNext();

    return oldFirst;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {
    Node currentNode;

    LinkedListIterator() {
      currentNode = first;
    }

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public T next() {
      T item = currentNode.getItem();

      currentNode = currentNode.getNext();

      return item;
    }
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
