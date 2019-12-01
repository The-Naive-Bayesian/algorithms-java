package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BagTests {
  @Test
  void constructorDoesntThrow() {
    new Bag<Integer>(1);
  }

  @Test
  void constructorThrowsForZeroInitialCapacity() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Bag<Integer>(0)
    );
  }

  @Test
  void constructorThrowsForNegativeInitialCapacity() {
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
