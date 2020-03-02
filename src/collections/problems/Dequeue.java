package collections.problems;

import java.util.Iterator;

// For Sedgewick, problem 1.3.33
public class Dequeue<T> implements Iterable<T> {
  private DoubleLinkNode<T> first;
  private DoubleLinkNode<T> last;

  void pushLeft(T item) {
    DoubleLinkNode<T> newNode = new DoubleLinkNode<>(item);
    newNode.next = first;
    if (first != null) first.prev = newNode;
    first = newNode;
    if (last == null) last = newNode;
  }

  void pushRight(T item) {
    DoubleLinkNode<T> newNode = new DoubleLinkNode<>(item);
    newNode.prev = last;
    if (last != null) last.next = newNode;
    last = newNode;
    if (first == null) first = newNode;
  }

  T popLeft() {
    if (first == null) return null;
    T item = first.item;

    first = first.next;
    if (first != null) first.prev = null;
    else last = null;

    return item;
  }

  T popRight() {
    if (last == null) return null;
    T item = last.item;

    last = last.prev;
    if (last != null) last.next = null;
    else first = null;

    return item;
  }

  boolean isEmpty() {
    return first == null;
  }

  public int size() {
    int i = 0;
    for (T item : this) {
      System.out.println(item);
      i++;
    }

    return i;
  }

  @Override
  public Iterator<T> iterator() {
    return new DequeueIterator();
  }

  private class DequeueIterator implements Iterator<T> {
    DoubleLinkNode<T> currentNode;

    DequeueIterator() {
      currentNode = first;
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

  private class DoubleLinkNode<T> {
    DoubleLinkNode<T> prev;
    DoubleLinkNode<T> next;
    T item;

    DoubleLinkNode(T item) {
      this.item = item;
    }
  }
}
