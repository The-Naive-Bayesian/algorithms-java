package linked_list;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTests {
  @Nested
  class Constructor {
    @Test
    void doesntThrow() {
      new LinkedList<Integer>();
    }
  }

  @Nested
  class ActionsOnFront {
    @Test
    void addDoesntThrow() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToFront(1);
    }

    @Test
    void addDoesntThrowOnMultiple() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToFront(1);
      list.addToFront(2);
      list.addToFront(3);
    }

    @Test
    void removeThrowsIfEmpty() {
      LinkedList<Integer> list = new LinkedList<>();

      assertThrows(NoSuchElementException.class, list::removeFirst);
    }

    @Test
    void removeRetrievesFirstValue() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToFront(3);
      assertEquals(3, list.removeFirst());
    }

    @Test
    void removeRetrievesFirstValueOnMultiple() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToFront(1);
      list.addToFront(2);
      list.addToFront(3);

      assertEquals(3, list.removeFirst());
      assertEquals(2, list.removeFirst());
      assertEquals(1, list.removeFirst());
    }
  }

  @Nested
  class ActionsOnEnd {
    @Test
    void addToEndDoesntThrow() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToEnd(1);
    }

    @Test
    void addToEndDoesntThrowOnMultiple() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToEnd(1);
      list.addToEnd(2);
      list.addToEnd(3);
    }

    @Test
    void addToEndAddsToTheEnd() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToEnd(1);
      list.addToEnd(2);
      list.addToEnd(3);

      assertEquals(1, list.removeFirst());
      assertEquals(2, list.removeFirst());
      assertEquals(3, list.removeFirst());
    }
  }

  @Nested
  class InterleavedFrontAndEndActions {
    @Test
    void interleavedAdditionsStartingWithFrontWork() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToFront(1);
      list.addToEnd(2);
      list.addToFront(3);

      assertEquals(3, list.removeFirst());
      assertEquals(1, list.removeFirst());
      assertEquals(2, list.removeFirst());
    }

    @Test
    void interleavedAdditionsStartingWithEndWork() {
      LinkedList<Integer> list = new LinkedList<>();

      list.addToEnd(1);
      list.addToFront(2);
      list.addToEnd(3);

      assertEquals(2, list.removeFirst());
      assertEquals(1, list.removeFirst());
      assertEquals(3, list.removeFirst());
    }
  }
}
