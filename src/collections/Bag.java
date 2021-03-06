package collections;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
  private LinkedListWithLastLink<T> linkedList;

  Bag() {
    linkedList = new LinkedListWithLastLink<>();
  }

  void add(T item) {
    linkedList.insertFirst(item);
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
