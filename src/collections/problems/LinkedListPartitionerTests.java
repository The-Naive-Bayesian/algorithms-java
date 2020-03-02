package collections.problems;

import collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListPartitionerTests {
  LinkedList<Integer> list;
  LinkedListPartitioner<Integer> partitioner;

  @BeforeEach
  void initializeListAndPartitioner() {
    list = new LinkedList<>();
    partitioner = new LinkedListPartitioner<>();
  }

  @Test
  void happyPathWorks() {
    list.insertFirst(2);
    list.insertFirst(3);
    list.insertFirst(0);
    list.insertFirst(1);
    list.insertFirst(4);
    int length = 5;

    int value = 2;
    LinkedListPartitioner<Integer> partitioner = new LinkedListPartitioner<>();
    LinkedList<Integer> partitionedList = partitioner.partition(list, value);

    Integer[] expectedValues = {0,1,2,3,4};
    int i = 0;
    for (Integer val : partitionedList) {
      assertEquals(expectedValues[i], val);
      i++;
    }

    // Assert we've seen all values in the expected list
    assertEquals(length, i);
  }

  @Test
  void partitionValueHigherWorks() {
    list.insertFirst(2);
    list.insertFirst(3);
    list.insertFirst(0);
    list.insertFirst(1);
    list.insertFirst(4);
    int length = 5;

    int value = 10;
    LinkedListPartitioner<Integer> partitioner = new LinkedListPartitioner<>();
    LinkedList<Integer> partitionedList = partitioner.partition(list, value);

    Integer[] expectedValues = {2,3,0,1,4};
    int i = 0;
    for (Integer val : partitionedList) {
      assertEquals(expectedValues[i], val);
      i++;
    }

    // Assert we've seen all values in the expected list
    assertEquals(length, i);
  }

  @Test
  void partitionValueLowerWorks() {
    list.insertFirst(2);
    list.insertFirst(3);
    list.insertFirst(0);
    list.insertFirst(1);
    list.insertFirst(4);
    int length = 5;

    int value = -1;
    LinkedListPartitioner<Integer> partitioner = new LinkedListPartitioner<>();
    LinkedList<Integer> partitionedList = partitioner.partition(list, value);

    Integer[] expectedValues = {2,3,0,1,4};
    int i = 0;
    for (Integer val : partitionedList) {
      assertEquals(expectedValues[i], val);
      i++;
    }

    // Assert we've seen all values in the expected list
    assertEquals(length, i);
  }

  @Test
  void emptyListWorks() {
    partitioner.partition(list, 0);
  }
}
