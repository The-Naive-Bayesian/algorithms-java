package collections.queue;

import linked_list.LinkedList;

import java.util.Iterator;

public class LinkedListQueue<T> implements Queue<T> {
  private LinkedList<T> list;
  private int size;

  public LinkedListQueue() {
    list = new LinkedList<>();
    size = 0;
  }

  public void enqueue(T item) {
    list.addToEnd(item);
    size++;
  }

  public T dequeue() {
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
