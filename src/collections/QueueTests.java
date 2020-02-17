package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTests {
  Queue<Integer> queue;

  @BeforeEach
  void createEmptyQueue() {
    queue = new Queue<>();
  }

  @Test
  void itEnqueuesWithoutError() {
      queue.enqueue(1);
  }

  @Test
  void itIsEmptyAfterConstruction() {
      assertTrue(queue.isEmpty());
  }

  @Test
  void itIsNotEmptyAfterEnqueuingItem() {
      queue.enqueue(0);
      assertFalse(queue.isEmpty());
  }

  @Test
  void itReturnsTheCorrectSize() {
      assertEquals(queue.size(), 0);
      queue.enqueue(1);
      assertEquals(queue.size(), 1);
      queue.enqueue(2);
      assertEquals(queue.size(), 2);
  }

  @Test
  void itDequeuesFIFO() {
    queue.enqueue(3);
    queue.enqueue(4);

    assertEquals(queue.dequeue(), 3);
    assertEquals(queue.dequeue(), 4);
  }
}
