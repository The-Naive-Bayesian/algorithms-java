package collections;

import java.util.Arrays;
import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
  private int size;
  private T[] arr;

  public Bag(int initialCapacity) throws IllegalArgumentException {
    if (initialCapacity <= 0) throw new IllegalArgumentException("Cannot have initial capacity less than one");
    size = 0;
    arr = (T[]) new Object[initialCapacity];
  }

  public void add(T item) {
    if (size == getCapacity()) {
      doubleCapacity();
    }

    addItem(item);
  }

  private void doubleCapacity() {
    arr = Arrays.copyOf(arr, 2 * getCapacity());
  }

  private int getCapacity() {
    return arr.length;
  }

  private void addItem(T item) {
    arr[size] = item;
    size++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Iterator<T> iterator() {
    return new BagIterator();
  }

  private class BagIterator implements Iterator<T> {
    private int index = size - 1;

    public boolean hasNext() {
      return index > 0;
    }

    public T next() {
      return arr[index--];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
