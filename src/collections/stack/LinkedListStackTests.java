package collections.stack;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListStackTests {
  @Nested
  class Constructor {
    @Test
    void constructor() {
      new LinkedListStack<>();
    }

    @Test
    void initialSizeIsZero() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      assertEquals(0, stack.size());
    }
  }

  @Nested
  class Push {
    @Test
    void pushDoesntThrow() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      stack.push(1);
    }

    @Test
    void pushIncreasesSize() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      stack.push(1);
      assertEquals(1, stack.size());
      stack.push(1);
      assertEquals(2, stack.size());
    }

    @Test
    void pushWorksAboveInitialCapacity() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      stack.push(1);
      assertEquals(1, stack.size());
      stack.push(1);
      assertEquals(2, stack.size());
    }
  }

  @Nested
  class Pop {
    @Test
    void throwsWhileEmpty() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    void returnsMostRecentlyAddedValue() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();
      stack.push(1);
      stack.push(2);

      assertEquals(2, stack.pop());
    }

    @Test
    void increasesSize() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      stack.push(1);
      assertEquals(1, stack.size());
      stack.push(1);
      assertEquals(2, stack.size());
    }

    @Test
    void worksWhenEmptyingStack() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      int maxSize = 8;
      for (int i = 0; i < maxSize; i++) {
        stack.push(i);
      }

      for (int i = 0; i < maxSize; i++) {
        stack.pop();
      }
    }
  }

  @Nested
  class IsEmpty {
    @Test
    void returnsTrueWhenEmpty() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();

      assertTrue(stack.isEmpty());
    }

    @Test
    void returnsFalseWhenNotEmpty() {
      LinkedListStack<Integer> stack = new LinkedListStack<>();
      stack.push(0);

      assertFalse(stack.isEmpty());
    }
  }

  @Nested
  class Iterator {
    @Test
    void allowsForEach() {
      ArrayStack<Integer> stack = new ArrayStack<>(10);

      Integer[] expectedValues = new Integer[8];
      for (int i = 0; i < 8; i++) {
        stack.push(i);
        expectedValues[7 - i] = i;
      }

      int index = 0;
      for (Integer number : stack) {
        assertEquals(expectedValues[index++], number);
      }

      assertEquals(8, index, "At least one item in stack wasn't iterated through");
    }
  }

}
