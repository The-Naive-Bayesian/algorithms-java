package collections.bag;

public interface Bag<T> extends Iterable<T> {
  void add(T item);
  boolean isEmpty();
  int size();
}
