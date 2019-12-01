package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
  private int size;
  private T[] arr;

  public Stack(int initialCapacity) {
    if (initialCapacity <= 0) throw new IllegalArgumentException("Cannot have initial capacity less than one");
    size = 0;
    arr = (T[]) new Object[initialCapacity];
  }

  public void push(T item) {
    if (size == getCapacity()) {
      doubleCapacity();
    }
    pushItem(item);
  }

  private void pushItem(T item) {
    arr[size] = item;
    size++;
  }

  public T pop() {
    T item = popItem();

    if(size < getCapacity() / 4) {
      halveCapacity();
    }

    return item;
  }

  private T popItem() {
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
    return new LifoIterator();
  }

  private class LifoIterator implements Iterator<T> {
    private int index = size - 1;

    @Override
    public boolean hasNext() {
      return index >= 0;
    }

    @Override
    public T next() {
      return arr[index--];
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}
