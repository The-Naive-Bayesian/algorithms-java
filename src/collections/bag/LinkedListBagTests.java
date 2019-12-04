package collections.bag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBagTests {
  @Test
  void doesntThrow() {
    new LinkedListBag();
  }

  @Test
  void sizeZeroBeforeAddingItems() {
    Bag<Integer> bag = new LinkedListBag<>();

    assertEquals(0, bag.size());
  }

  @Test
  void isEmptyTrueBeforeAddingItems() {
    Bag<Integer> bag = new LinkedListBag<>();

    assertTrue(bag.isEmpty());
  }

  @Test
  void addDoesntThrow() {
    Bag<Integer> bag = new LinkedListBag<>();

    bag.add(1);
  }

  @Test
  void isEmptyFalseAfterAddingItem() {
    Bag<Integer> bag = new LinkedListBag<>();

    bag.add(2);
    assertFalse(bag.isEmpty());
  }

  @Test
  void sizeEqualsItemsAdded() {
    Bag<Integer> bag = new LinkedListBag<>();

    bag.add(1);
    assertEquals(1, bag.size());
    bag.add(2);
    assertEquals(2, bag.size());
    bag.add(3);
    assertEquals(3, bag.size());
  }

  @Test
  void itAllowsIteration() {
    Bag<Integer> bag = new LinkedListBag<>();

    for (int i = 0; i < 8; i++) {
      bag.add(i);
    }

    boolean[] seen = new boolean[8];
    for (Integer number : bag) {
      if (seen[number]) {
        fail();
      }
      seen[number] = true;
    }

    for (boolean viewed : seen) {
      assertTrue(viewed, "At least one item in bag wasn't returned");
    }

  }
}
