package collections;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
  void add(T item) {}

  boolean isEmpty() {
    return true;
  }

  int size() {
    return 0;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
