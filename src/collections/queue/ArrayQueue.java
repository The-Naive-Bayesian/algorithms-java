package collections.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
  private int head;
  private int size;
  private T[] arr;

  public ArrayQueue(int initialCapacity) {
    if (initialCapacity <= 0) throw new IllegalArgumentException("Cannot have initial capacity less than one");
    head = 0;
    size = 0;
    arr = (T[]) new Object[initialCapacity];
  }

  public void enqueue(T item) {
    if (size == capacity()) {
      doubleCapacity();
    }

    enqueueItem(item);
  }

  private void enqueueItem(T item) {
    arr[tailIndex()] = item;
    size++;
  }

  private int tailIndex() {
    return (head + size) % capacity();
  }

  public T dequeue() {
    T item = dequeueItem();

    if (size() < capacity() / 4) {
      halveCapacity();
    }

    return item;
  }

  private T dequeueItem() {
    if (size() == 0) {
      throw new NoSuchElementException();
    }

    T item = arr[head];
    arr[head] = null;

    head = (head + 1) % capacity();

    return item;
  }

  private void doubleCapacity() {
    arr = getLeftShiftedArrayCopy(capacity() * 2);
    head = 0;
  }

  private void halveCapacity() {
    arr = getLeftShiftedArrayCopy(capacity() / 2);
    head = 0;
  }

  private T[] getLeftShiftedArrayCopy(int capacity) {
    if (capacity < size) {
      throw new IllegalArgumentException("Target array must be large enough to contain all items");
    }

    T[] targetArray = (T[]) new Object[capacity() * 2];
    for (int i = 0; i < size; i++) {
      targetArray[i] = arr[(head + i) % capacity()];
    }

    return targetArray;
  }

  private int capacity() {
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
    int headOffset = 0;

    public boolean hasNext() {
      return headOffset < size;
    }

    public T next() {
      T item = arr[(head + headOffset) % capacity()];
      headOffset++;
      return item;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
