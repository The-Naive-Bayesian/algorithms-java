package collections.bag;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ArrayBagTests {
  @Nested
  class Constructor {
    @Test
    void doesntThrow() {
      new ArrayBag<Integer>(1);
    }

    @Test
    void throwsForZeroInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new ArrayBag<Integer>(0)
      );
    }

    @Test
    void throwsForNegativeInitialCapacity() {
      assertThrows(
          IllegalArgumentException.class,
          () -> new ArrayBag<Integer>(-1)
      );
    }

    @Test
    void initialSizeIsZero() {
      ArrayBag bag = new ArrayBag<Integer>(10);

      assertEquals(0, bag.size());
    }
  }

  @Nested
  class Add {
    @Test
    void addDoesntThrow() {
      ArrayBag bag = new ArrayBag<Integer>(10);

      bag.add(1);
    }

    @Test
    void addIncreasesSize() {
      ArrayBag bag = new ArrayBag<Integer>(10);

      bag.add(1);
      assertEquals(1, bag.size());
      bag.add(1);
      assertEquals(2, bag.size());
    }

    @Test
    void addWorksAboveInitialCapacity() {
      ArrayBag bag = new ArrayBag<Integer>(1);

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
      ArrayBag bag = new ArrayBag<Integer>(1);

      assertTrue(bag.isEmpty());
    }

    @Test
    void returnsFalseWhenNotEmpty() {
      ArrayBag bag = new ArrayBag<Integer>(1);
      bag.add(0);

      assertFalse(bag.isEmpty());
    }
  }

  @Nested
  class Iterator {
    @Test
    void allowsForEach() {
      ArrayBag<Integer> bag = new ArrayBag<>(10);

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
}
