package collections.queue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTests {
  @Nested
  class Constructor {
    @Test
    void constructor() {
      new ArrayQueue<Integer>(10);
    }

    @Test
    void constructorThrowsForZeroInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new ArrayQueue<Integer>(0)
      );
    }

    @Test
    void constructorThrowsForNegativeInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new ArrayQueue<Integer>(-1)
      );
    }

    @Test
    void initialSizeIsZero() {
      ArrayQueue queue = new ArrayQueue<Integer>(10);

      assertEquals(0, queue.size());
    }
  }

  @Nested
  class Enqueue {
    @Test
    void enqueueDoesntThrow() {
      ArrayQueue queue = new ArrayQueue<Integer>(10);

      queue.enqueue(1);
    }

    @Test
    void enqueueIncreasesSize() {
      ArrayQueue queue = new ArrayQueue<Integer>(10);

      queue.enqueue(1);
      assertEquals(1, queue.size());
      queue.enqueue(1);
      assertEquals(2, queue.size());
    }

    @Test
    void enqueueWorksAboveInitialCapacity() {
      ArrayQueue queue = new ArrayQueue<Integer>(1);

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
      ArrayQueue queue = new ArrayQueue<Integer>(10);

      assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @Test
    void returnsFirstAddedValue() {
      ArrayQueue queue = new ArrayQueue<Integer>(10);
      queue.enqueue(1);
      queue.enqueue(2);

      assertEquals(1, queue.dequeue());
    }

    @Test
    void increasesSize() {
      ArrayQueue queue = new ArrayQueue<Integer>(10);

      queue.enqueue(1);
      assertEquals(1, queue.size());
      queue.enqueue(1);
      assertEquals(2, queue.size());
    }

    @Test
    void worksWhenEmptyingQueue() {
      ArrayQueue queue = new ArrayQueue<Integer>(1);

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
      ArrayQueue queue = new ArrayQueue<Integer>(1);

      assertTrue(queue.isEmpty());
    }

    @Test
    void returnsFalseWhenNotEmpty() {
      ArrayQueue queue = new ArrayQueue<Integer>(1);
      queue.enqueue(0);

      assertFalse(queue.isEmpty());
    }
  }

  @Nested
  class Iterator {
    @Test
    void allowsForEach() {
      ArrayQueue<Integer> queue = new ArrayQueue<>(10);

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
