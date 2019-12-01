package collections;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTests {
  @Nested
  class Constructor {
    @Test
    void constructor() {
      new Stack<Integer>(10);
    }

    @Test
    void constructorThrowsForZeroInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new Stack<Integer>(0)
      );
    }

    @Test
    void constructorThrowsForNegativeInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new Stack<Integer>(-1)
      );
    }

    @Test
    void initialSizeIsZero() {
      Stack stack = new Stack<Integer>(10);

      assertEquals(0, stack.size());
    }
  }

  @Nested
  class Push {
    @Test
    void pushDoesntThrow() {
      Stack stack = new Stack<Integer>(10);

      stack.push(1);
    }

    @Test
    void pushIncreasesSize() {
      Stack stack = new Stack<Integer>(10);

      stack.push(1);
      assertEquals(1, stack.size());
      stack.push(1);
      assertEquals(2, stack.size());
    }

    @Test
    void pushWorksAboveInitialCapacity() {
      Stack stack = new Stack<Integer>(1);

      stack.push(1);
      assertEquals(1, stack.size());
      stack.push(1);
      assertEquals(2, stack.size());
    }
  }

  @Nested
  class Dequeue {
    @Test
    void returnsNullWhileEmpty() {
      Stack stack = new Stack<Integer>(10);

      assertNull(stack.pop());
    }

    @Test
    void returnsMostRecentlyAddedValue() {
      Stack stack = new Stack<Integer>(10);
      stack.push(1);
      stack.push(2);

      assertEquals(2, stack.pop());
    }

    @Test
    void increasesSize() {
      Stack stack = new Stack<Integer>(10);

      stack.push(1);
      assertEquals(1, stack.size());
      stack.push(1);
      assertEquals(2, stack.size());
    }

    @Test
    void worksWhenEmptyingStack() {
      Stack stack = new Stack<Integer>(1);

      for (int i = 0; i < 6; i++) {
        stack.push(i);
      }

      for (int i = 0; i < 6; i++) {
        stack.pop();
      }
    }
  }

  @Nested
  class IsEmpty {
    @Test
    void returnsTrueWhenEmpty() {
      Stack stack = new Stack<Integer>(1);

      assertTrue(stack.isEmpty());
    }

    @Test
    void returnsFalseWhenNotEmpty() {
      Stack stack = new Stack<Integer>(1);
      stack.push(0);

      assertFalse(stack.isEmpty());
    }
  }
}
