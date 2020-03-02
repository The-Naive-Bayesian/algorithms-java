package collections.problems;

import collections.Node;

// For Sedgewick, problem 1.3.30
public class ReverseList {
  static <T> Node<T> reverse(Node<T> first) {
    if (first == null) return null;
    Node<T> reversed = null;

    Node<T> currentNode = first;
    while (currentNode != null) {
      Node<T> temp = currentNode.next;
      currentNode.next = reversed;
      reversed = currentNode;
      currentNode = temp;
    }

    return reversed;
  }
}
