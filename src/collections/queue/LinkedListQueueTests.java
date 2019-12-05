package collections.queue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LinkedListQueueTests {
  @Nested
  class Constructor {
    @Test
    void constructor() {
      new LinkedListQueue<>();
    }

    @Test
    void initialSizeIsZero() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      assertEquals(0, queue.size());
    }
  }

  @Nested
  class Enqueue {
    @Test
    void enqueueDoesntThrow() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      queue.enqueue(1);
    }

    @Test
    void enqueueIncreasesSize() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      queue.enqueue(1);
      assertEquals(1, queue.size());
      queue.enqueue(1);
      assertEquals(2, queue.size());
    }

    @Test
    void enqueueWorksAboveInitialCapacity() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      queue.enqueue(1);
      assertEquals(1, queue.size());
      queue.enqueue(1);
      assertEquals(2, queue.size());
    }
  }

  @Nested
  class Dequeue {
    @Test
    void throwsWhileEmpty() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    void returnsFirstAddedValue() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();
      queue.enqueue(1);
      queue.enqueue(2);

      assertEquals(1, queue.dequeue());
    }

    @Test
    void increasesSize() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      queue.enqueue(1);
      assertEquals(1, queue.size());
      queue.enqueue(1);
      assertEquals(2, queue.size());
    }

    @Test
    void worksWhenEmptyingQueue() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      int maxSize = 8;
      for (int i = 0; i < maxSize; i++) {
        queue.enqueue(i);
      }

      for (int i = 0; i < maxSize; i++) {
        queue.dequeue();
      }
    }
  }

  @Nested
  class IsEmpty {
    @Test
    void returnsTrueWhenEmpty() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      assertTrue(queue.isEmpty());
    }

    @Test
    void returnsFalseWhenNotEmpty() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();
      queue.enqueue(0);

      assertFalse(queue.isEmpty());
    }
  }

  @Nested
  class Iterator {
    @Test
    void allowsForEach() {
      LinkedListQueue<Integer> queue = new LinkedListQueue<>();

      Integer[] expectedValues = new Integer[8];
      for (int i = 0; i < 8; i++) {
        queue.enqueue(i);
        expectedValues[i] = i;
      }

      int index = 0;
      for (Integer number : queue) {
        assertEquals(expectedValues[index++], number);
      }

      assertEquals(8, index, "At least one item in queue wasn't iterated through");
    }
  }

}
