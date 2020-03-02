package collections;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
  private LinkedListWithLastLink<T> linkedList;

  Stack() {
    linkedList = new LinkedListWithLastLink<>();
  }

  void push(T item) {
    linkedList.insertFirst(item);
  }

  T pop() {
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
