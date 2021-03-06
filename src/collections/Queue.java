package collections;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
  private LinkedListWithLastLink<T> linkedList;

  Queue() {
    linkedList = new LinkedListWithLastLink<>();
  }

  void enqueue(T item) {
    linkedList.insertLast(item);
  }

  T dequeue() {
    return linkedList.removeFirst();
  }

  boolean isEmpty() {
    return linkedList.isEmpty();
  }

  int size() {
    return linkedList.size();
  }

  @Override
  public Iterator<T> iterator() {
    return linkedList.iterator();
  }
}
