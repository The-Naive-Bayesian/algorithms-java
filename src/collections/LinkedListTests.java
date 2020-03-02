package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LinkedListTests {
  LinkedList<Integer> list;

  @BeforeEach
  void initializeList() {
    list = new LinkedList<>();
  }

  @Nested
  class Delete {
    @Test
    void worksForEmptyList() {
      list.delete(1);
    }

    @Test
    void worksForSingleItemWith0Index() {
      list.insertFirst(1);
      list.delete(0);
      assertEquals(0, list.size());
    }

    @Test
    void worksForSingleItemWithTooHighIndex() {
      list.insertFirst(1);
      list.delete(3);
      assertEquals(1, list.size());
    }

    @Test
    void worksForMiddleElement() {
      list.insertFirst(1);
      list.insertFirst(2);
      list.insertFirst(3);
      list.delete(1);
      assertEquals(3, list.removeFirst());
      assertEquals(1, list.removeFirst());
    }
  }

  @Nested
  class ReturnLast {
    @Test
    void worksForEmptyList() {
      Integer result = list.removeLast();

      assertNull(result);
    }

    @Test
    void worksForSingleItemList() {
      list.insertFirst(1);
      Integer result = list.removeLast();

      assertEquals(1, result);
    }

    @Test
    void worksForManyItemList() {
      list.insertFirst(1);
      list.insertFirst(2);
      list.insertFirst(3);
      list.insertFirst(4);

      assertEquals(1, list.removeLast());
      assertEquals(2, list.removeLast());
      assertEquals(3, list.removeLast());
      assertEquals(4, list.removeLast());
    }
  }

  @Nested
  class RecursiveMax {
    // Problem 1.3.28
    // We assume nonnegative integers only and return 0 if nothing present
    Integer recursiveMax(Node<Integer> node) {
      if (node == null) return 0;

      return Math.max(node.item, recursiveMax(node.next));
    }

    @Test
    void worksForEmpty() {
      assertEquals(0, recursiveMax(list.getFirst()));
    }

    @Test
    void worksForSingleItem() {
      list.insertFirst(3);
      assertEquals(3, recursiveMax(list.getFirst()));
    }

    @Test
    void worksForManyItems() {
      list.insertFirst(3);
      list.insertFirst(1);
      list.insertFirst(10);
      list.insertFirst(2);
      list.insertFirst(6);
      assertEquals(10, recursiveMax(list.getFirst()));
    }
  }
}
