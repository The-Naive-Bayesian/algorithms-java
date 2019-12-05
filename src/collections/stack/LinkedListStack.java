package collections.stack;

import linked_list.LinkedList;

import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T> {
  private LinkedList<T> list;
  private int size;

  public LinkedListStack() {
    list = new LinkedList<>();
    size = 0;
  }

  public void push(T item) {
    list.addToFront(item);
    size++;
  }

  public T pop() {
    size--;
    return list.removeFirst();
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Iterator<T> iterator() {
    return list.iterator();
  }
}
