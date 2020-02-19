package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class BagTests {
  Bag<Integer> bag;

  @BeforeEach
  void createEmptyBag() {
    bag = new Bag<>();
  }

  @Test
  void itAddsWithoutError() {
    bag.add(1);
  }

  @Test
  void itIsEmptyAfterConstruction() {
    assertTrue(bag.isEmpty());
  }

  @Test
  void itIsNotEmptyAfterAddingItem() {
    bag.add(0);
    assertFalse(bag.isEmpty());
  }

  @Test
  void itReturnsTheCorrectSize() {
    assertEquals(bag.size(), 0);
    bag.add(1);
    assertEquals(bag.size(), 1);
    bag.add(2);
    assertEquals(bag.size(), 2);
  }

  @Test
  void itIterates() {
    int[] values = {3, 4};

    bag.add(values[0]);
    bag.add(values[1]);

    // Order shouldn't matter
    int[] expected = Arrays.copyOf(values, values.length);
    int[] actual = new int[values.length];

    int i = 0;
    for (int value : bag) {
      actual[i++] = value;
    }

    // Sort actual and expected and compare item-by-item
    Arrays.sort(actual);
    Arrays.sort(expected);

    i = 0;
    for (int value : actual) {
      assertEquals(expected[i++], value, "Current iteration: " + (i - 1));
    }

    // Validate we've seen all expected items
    assertEquals(expected.length, i);
  }
}
