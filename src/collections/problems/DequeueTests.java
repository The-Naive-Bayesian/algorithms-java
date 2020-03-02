package collections.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeueTests {
  Dequeue<Integer> dequeue;

  @BeforeEach
  void initializeDequeue() {
    dequeue = new Dequeue<>();
  }

  @Nested
  class SizeTests {
    @Test
    void whenEmpty() {
      assertEquals(0, dequeue.size());
    }

    @Test
    void whenItemsAdded() {
      dequeue.pushLeft(1);
      dequeue.pushLeft(2);
      dequeue.pushRight(2);

      assertEquals(3, dequeue.size());
    }

    @Test
    void whenItemsAddedThenRemoved() {
      dequeue.pushLeft(1);
      dequeue.pushRight(2);
      dequeue.popLeft();
      dequeue.popRight();
      assertEquals(0, dequeue.size());
    }
  }

  @Nested
  class IsEmptyTests {
    @Test
    void whenEmpty() {
      assertTrue(dequeue.isEmpty());
    }

    @Test
    void whenItemAdded() {
      dequeue.pushLeft(1);
      assertFalse(dequeue.isEmpty());
    }

    @Test
    void whenItemAddedThenRemoved() {
      dequeue.pushLeft(1);
      dequeue.popLeft();
      assertTrue(dequeue.isEmpty());
    }
  }


  @Nested
  class PushPullTests {
    @Test
    void pushLeftPopLeft() {
      dequeue.pushLeft(1);
      dequeue.pushLeft(2);
      assertEquals(2, dequeue.popLeft());
      assertEquals(1, dequeue.popLeft());
    }

    @Test
    void pushLeftPopRight() {
      dequeue.pushLeft(1);
      dequeue.pushLeft(2);
      assertEquals(1, dequeue.popRight());
      assertEquals(2, dequeue.popRight());
    }

    @Test
    void pushRightPopRight() {
      dequeue.pushRight(1);
      dequeue.pushRight(2);
      assertEquals(2, dequeue.popRight());
      assertEquals(1, dequeue.popRight());
    }

    @Test
    void pushRightPopLeft() {
      dequeue.pushRight(1);
      dequeue.pushRight(2);
      assertEquals(1, dequeue.popLeft());
      assertEquals(2, dequeue.popLeft());
    }

    @Test
    void pushBothPopBoth() {
      dequeue.pushLeft(1); // 1
      dequeue.pushRight(2);// 1, 2
      dequeue.pushLeft(3); // 3, 1, 2
      dequeue.pushRight(4);// 3, 1, 2, 4
      assertEquals(4, dequeue.popRight());
      assertEquals(3, dequeue.popLeft());
      assertEquals(2, dequeue.popRight());
      assertEquals(1, dequeue.popLeft());
    }
  }
}
