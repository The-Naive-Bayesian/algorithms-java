package collections;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BagTests {
  @Nested
  class Constructor {
    @Test
    void doesntThrow() {
      new Bag<Integer>(1);
    }

    @Test
    void throwsForZeroInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new Bag<Integer>(0)
      );
    }

    @Test
    void throwsForNegativeInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new Bag<Integer>(-1)
      );
    }

    @Test
    void initialSizeIsZero() {
      Bag bag = new Bag<Integer>(10);

      assertEquals(0, bag.size());
    }
  }

  @Nested
  class Add {
    @Test
    void addDoesntThrow() {
      Bag bag = new Bag<Integer>(10);

      bag.add(1);
    }

    @Test
    void addIncreasesSize() {
      Bag bag = new Bag<Integer>(10);

      bag.add(1);
      assertEquals(1, bag.size());
      bag.add(1);
      assertEquals(2, bag.size());
    }

    @Test
    void addWorksAboveInitialCapacity() {
      Bag bag = new Bag<Integer>(1);

      bag.add(1);
      assertEquals(1, bag.size());
      bag.add(1);
      assertEquals(2, bag.size());
    }
  }

  @Nested
  class IsEmpty {
    @Test
    void returnsTrueWhenEmpty() {
      Bag bag = new Bag<Integer>(1);

      assertTrue(bag.isEmpty());
    }

    @Test
    void returnsFalseWhenNotEmpty() {
      Bag bag = new Bag<Integer>(1);
      bag.add(0);

      assertFalse(bag.isEmpty());
    }
  }

  @Nested
  class Iterator {
    @Test
    void allowsForEach() {
      Bag<Integer> bag = new Bag<>(10);

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
    }
  }
}
