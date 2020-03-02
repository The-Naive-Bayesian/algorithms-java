package collections.problems;

import collections.LinkedList;
import collections.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReverseListTest {
  LinkedList<Integer> list;

  @BeforeEach
  void initializeList() {
    list = new LinkedList<>();
  }

  @Test
  void happyPath() {
    list.insertFirst(3);
    list.insertFirst(2);
    list.insertFirst(1);

    Node<Integer> reversed = ReverseList.reverse(list.getFirst());

    assertEquals(3, reversed.item);
    reversed = reversed.next;
    assertEquals(2, reversed.item);
    reversed = reversed.next;
    assertEquals(1, reversed.item);
  }

  @Test
  void lengthOne() {
    list.insertFirst(3);

    Node<Integer> reversed = ReverseList.reverse(list.getFirst());

    assertEquals(3, reversed.item);
  }

  @Test
  void lengthZero() {
    Node<Integer> reversed = ReverseList.reverse(list.getFirst());

    assertNull(reversed);
  }
}
