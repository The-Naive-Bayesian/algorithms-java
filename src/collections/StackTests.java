package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTests {
  Stack<Integer> stack;

  @BeforeEach
  void createEmptyQueue() {
    stack = new Stack<>();
  }

  @Test
  void itPushesWithoutError() {
    stack.push(1);
  }

  @Test
  void itIsEmptyAfterConstruction() {
    assertTrue(stack.isEmpty());
  }

  @Test
  void itIsNotEmptyAfterPushingItem() {
    stack.push(0);
    assertFalse(stack.isEmpty());
  }

  @Test
  void itReturnsTheCorrectSize() {
    assertEquals(stack.size(), 0);
    stack.push(1);
    assertEquals(stack.size(), 1);
    stack.push(2);
    assertEquals(stack.size(), 2);
  }

  @Test
  void itPopsLIFO() {
    stack.push(3);
    stack.push(4);

    assertEquals(stack.pop(), 4);
    assertEquals(stack.pop(), 3);
  }

  @Test
  void itIterates() {
    int[] values = {3, 4};

    stack.push(values[0]);
    stack.push(values[1]);

    int i = values.length;
    for (Integer value : stack) {
      assertEquals(values[--i], value);
    }
    assertEquals(0, i);
  }

}
