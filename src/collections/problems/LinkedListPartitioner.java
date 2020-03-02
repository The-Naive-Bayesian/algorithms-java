package collections.problems;

import collections.LinkedList;
import collections.Node;

// For Cracking the Coding Interview, problem 2.4
public class LinkedListPartitioner<T extends Comparable> {
  LinkedList<T> partition(LinkedList<T> linkedList, T partitionValue) {
    LinkedList<T> lower = new LinkedList<>();
    LinkedList<T> upper = new LinkedList<>();

    Node<T> currentNode = linkedList.getFirst();
    if (currentNode == null) return lower;

    while(currentNode != null) {
      if (currentNode.item.compareTo(partitionValue) < 0) {
        lower.insertFirst(currentNode.item);
      } else {
        upper.insertFirst(currentNode.item);
      }
      currentNode = currentNode.next;
    }

    return append(lower, upper);
  }

  LinkedList<T> append(LinkedList<T> list1, LinkedList<T> list2) {
    if (list1.getFirst() == null) return list2;
    if (list2.getFirst() == null) return list1;

    Node<T> currentNode = list1.getFirst();
    while (currentNode.next != null) {
      currentNode = currentNode.next;
    }

    currentNode.next = list2.getFirst();
    return list1;
  }
}
