package collections;

import java.util.Arrays;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
  private int size;
  private T[] arr;

  public Stack(int initialCapacity) {
    size = 0;
    arr = (T[]) new Object[initialCapacity];
  }

  public void push(T item) {
    if (size > 2 * getCapacity() / 3) {
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

    if(size < getCapacity() / 3) {
      halveCapacity();
    }

    return item;
  }

  private T popItem() {
    T item = arr[size - 1];
    size--;
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

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
