package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
  private int size;
  private T[] arr;

  public Queue(int initialCapacity) {
    if (initialCapacity <= 0) throw new IllegalArgumentException("Cannot have initial capacity less than one");
    size = 0;
    arr = (T[]) new Object[initialCapacity];
  }

  public void enqueue(T item) {
    enqueueItem(item);

    if (size == getCapacity()) {
      doubleCapacity();
    }
  }

  private void enqueueItem(T item) {
    if (size >= 0) System.arraycopy(arr, 0, arr, 1, size);
    arr[0] = item;
    size++;
  }

  public T dequeue() {
    T item = dequeueItem();

    if (size < getCapacity() / 4) {
      halveCapacity();
    }

    return item;
  }

  private T dequeueItem() {
    if (size == 0) {
      throw new NoSuchElementException();
    }

    T item = arr[--size];
    arr[size] = null;
    return item;
  }

  private void doubleCapacity() {
    arr = Arrays.copyOf(arr, getCapacity() * 2);
  }

  private void halveCapacity() {
    arr = Arrays.copyOf(arr, getCapacity() / 2);
  }

  private int getCapacity() {
    return arr.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Iterator<T> iterator() {
    return new FifoIterator();
  }

  private class FifoIterator implements Iterator<T> {
    int index = size - 1;

    public boolean hasNext() {
      return index >= 0;
    }

    public T next() {
      return arr[index--];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
