package collections.bag;

import linked_list.LinkedList;
import java.util.Iterator;

public class LinkedListBag<T> implements Bag<T> {
  private LinkedList<T> list;
  private int size;

  public LinkedListBag() {
    list = new LinkedList<>();
    size = 0;
  }

  public void add(T item) {
    list.addToFront(item);
    size++;
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
