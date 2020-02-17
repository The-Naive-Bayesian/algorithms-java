package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
